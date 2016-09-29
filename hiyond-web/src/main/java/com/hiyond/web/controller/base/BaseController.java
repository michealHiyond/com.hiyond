package com.hiyond.web.controller.base;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BaseController {

    public void responseWrite(Object o, HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(o);
            printWriter.flush();
            printWriter.close();
        }catch (Exception e){

        }

    }

}
