package seu.sun.babytun.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import seu.sun.babytun.Model.Goods;
import seu.sun.babytun.Model.GoodsEvaluate;
import seu.sun.babytun.Service.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsCoverService goodsCoverService;
    @Autowired
    private GoodsDetailService goodsDetailService;
    @Autowired
    private GoodsParamService goodsParamService;
    @Autowired
    private GoodsEvaluateService goodsEvaluateService;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${server.port}")
    private String port;

    Logger logger= LoggerFactory.getLogger(GoodsController.class);

    @GetMapping("/goods")
    public ModelAndView showGoods(@RequestParam Integer gid){
        logger.info("port:"+port);
        ModelAndView modelAndView=new ModelAndView("/goods");
        Goods goods = goodsService.selectByPrimaryKey(gid);
        modelAndView.addObject("goods",goods);
        modelAndView.addObject("covers",goodsCoverService.selectBygid(gid));
        modelAndView.addObject("details",goodsDetailService.selectBygoodsId(gid));
        modelAndView.addObject("params",goodsParamService.selectBygoodsId(gid));
        return modelAndView;
    }

    @GetMapping("/goods-{gid}.html")
    public ModelAndView showGoodsnginx(@PathVariable("gid") Integer gid){
        logger.info("port:"+port);
        ModelAndView modelAndView=new ModelAndView("/goods");
        Goods goods = goodsService.selectByPrimaryKey(gid);
        modelAndView.addObject("goods",goods);
        modelAndView.addObject("covers",goodsCoverService.selectBygid(gid));
        modelAndView.addObject("details",goodsDetailService.selectBygoodsId(gid));
        modelAndView.addObject("params",goodsParamService.selectBygoodsId(gid));
        return modelAndView;
    }

    @GetMapping("/goods/{gid}")
    @ResponseBody
    public String GoodsStatic(@PathVariable(value = "gid") Integer gid) throws IOException {
        Context context=new Context();
        ModelAndView modelAndView=new ModelAndView("/goods");
        Goods goods = goodsService.selectByPrimaryKey(gid);
        modelAndView.addObject("goods",goods);
        modelAndView.addObject("covers",goodsCoverService.selectBygid(gid));
        modelAndView.addObject("details",goodsDetailService.selectBygoodsId(gid));
        modelAndView.addObject("params",goodsParamService.selectBygoodsId(gid));
        context.setVariables(modelAndView.getModel());
        File file=new File("E:\\babytun\\goods\\"+gid+".html");
        FileWriter fileWriter=new FileWriter(file);
        templateEngine.process(modelAndView.getViewName(),context,fileWriter);
        fileWriter.close();
        return file.getAbsolutePath();
    }

    @GetMapping("/goods/all")
    @ResponseBody
    public String GoodsAll() throws IOException {
        Context context=new Context();
        List<Goods> goodsall = goodsService.selectAll();
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
        }

        return "ok";
    }

    @GetMapping("/evaluate/{goodsId}")
    @ResponseBody
    public List<GoodsEvaluate> findEvalutes(@PathVariable("goodsId") Long gId){
        return goodsEvaluateService.findEvaluates(gId);
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(String user, WebRequest webRequest){
        webRequest.setAttribute("user",user,webRequest.SCOPE_SESSION);
        return "port:"+port+"login success";
    }

    @GetMapping("/checklogin")
    @ResponseBody
    public String checklogin(WebRequest webRequest){
        String user = (String)webRequest.getAttribute("user", webRequest.SCOPE_SESSION);
        if (user!=null){
            return "port:"+port+",user"+user;
        }
        else {
            return "port:"+port+"redirect to login";
        }
    }


}
