package com.css.app.base.vcode.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slw.framework.context.SlwContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RefreshVCode {

    public RefreshVCode() {
    }

    public void execute(){
        Log log = LogFactory.getLog(VCodeResource.class);
        HttpServletResponse response= SlwContext.response();
        HttpSession session= SlwContext.request().getSession();
        BufferedImage image;
        try{
            int width=60, height=20;
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            Random random = new Random();

            g.setColor(getRandColor(200,250));
            g.fillRect(0, 0, width, height);
            g.setFont(new Font("Times New Roman",Font.PLAIN,18));

            g.setColor(getRandColor(160,200));
            for (int i=0;i<155;i++)
            {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                g.drawLine(x,y,x+xl,y+yl);
            }
            String sRand="";
            for (int i=0;i<4;i++){
                String rand=String.valueOf(random.nextInt(10));
                //String rand = "0";
                sRand+=rand;
                g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
                g.drawString(rand,13*i+6,16);
            }
            response.setHeader("P3P", "CP='IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT'");
            session.setAttribute("SystemSessionID_Donne",sRand);
            g.dispose();
            // 将图像输出到Servlet输出流中。
            ServletOutputStream sos = response.getOutputStream();
            ImageIO.write(image, "JPEG", sos);
            sos.close();
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }finally{
            image = null;
            log = null;
        }
    }
    private static Color getRandColor(int fc, int bc){
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

}
