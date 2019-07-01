import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class DownLoadServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //处理请求
        //读取要下载的文件
        File f = new File("/Users/shiliang/Desktop/hebao/测试Tinker2/patch_signed_7zip.apk");
        if(f.exists()){
            FileInputStream fis = new FileInputStream(f);
            String filename= URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题
            byte[] b = new byte[fis.available()];
            fis.read(b);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment; filename="+filename+"");
            //获取响应报文输出流对象
            ServletOutputStream out =response.getOutputStream();
            //输出
            out.write(b);
            out.flush();
            out.close();
        }else {
            PrintWriter writer = response.getWriter();
            writer.println("文件不存在");
        }

    }
}
