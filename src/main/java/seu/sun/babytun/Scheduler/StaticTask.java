package seu.sun.babytun.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import seu.sun.babytun.Model.Goods;
import seu.sun.babytun.Service.GoodsCoverService;
import seu.sun.babytun.Service.GoodsDetailService;
import seu.sun.babytun.Service.GoodsParamService;
import seu.sun.babytun.Service.GoodsService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class StaticTask {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsCoverService goodsCoverService;
    @Autowired
    private GoodsDetailService goodsDetailService;
    @Autowired
    private GoodsParamService goodsParamService;

    @Autowired
    private TemplateEngine templateEngine;

    //cron表达式 秒 分 时 日 月 星期 *代表所有
    @Scheduled(cron = "0 0/5 * * * ?")
    public void doStatic() throws IOException {
        Context context=new Context();
        List<Goods> goodsall = goodsService.selectLastUpdateTime();
        for (Goods goods:goodsall){
            Integer gid=goods.getGoodsId();
            ModelAndView modelAndView=new ModelAndView("/goods");
            modelAndView.addObject("goods",goodsService.selectByPrimaryKey(gid));
            modelAndView.addObject("covers",goodsCoverService.selectBygid(gid));
            modelAndView.addObject("details",goodsDetailService.selectBygoodsId(gid));
            modelAndView.addObject("params",goodsParamService.selectBygoodsId(gid));
            context.setVariables(modelAndView.getModel());
            File file=new File("E:\\babytun\\goods\\"+gid+".html");
            FileWriter fileWriter=new FileWriter(file);
            templateEngine.process(modelAndView.getViewName(),context,fileWriter);
            fileWriter.close();
            System.out.println(file+"已生成");
        }

    }
}
