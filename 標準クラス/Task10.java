/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp.applied.Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class Task10 extends HttpServlet {
        /* 課題10．紹介していないJAVAの標準クラスを利用して、処理を作成してください。
               講義では紹介されていないJAVAの標準クラスはたくさん存在します。
               1つJAVAの標準クラスを選び、実際にロジックを作成してみてください。
               また、この処理を作成するに当たり、下記を必ず実装してください。
            ①処理の経過を書き込むログファイルを作成する。
            ②処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
            ③書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
            ④最後に、ログファイルを読み込み、その内容を表示してください。
    使用した標準クラス：Math*/
    public static void main(String[] args)throws IOException{
            String name = "/Users/8mile_000/C/soeda_origin/開発/開発- JAVA/Java standard class/src/java/camp/applied/Task/log.file.txt";
            FileWriter filename = new FileWriter(name);                         //ファイル出力用としてインスタンス化
            BufferedWriter bw = new BufferedWriter(filename);                   //PrintWriterを作成する為BufferedWriterのオブジェクトを利用する
            PrintWriter write = new PrintWriter(bw);                            //PrintWriterをインスタンス化
                                                                                //これにより文字列だけではなく、int型やboolean型の値もそのまま出力するように記述することが可能
                                                                                
            Date start = new Date();                                            //SimpleDateFormatを使用して開始,終了日時を記入
            SimpleDateFormat start_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String start_string = start_1.format(start);                        //開始日時の処理終了
            
            
            Date finish = new Date();
            SimpleDateFormat finish_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String finish_string = finish_1.format(finish);                     //終了日時の処理終了
            
            out.println("洗濯した標準クラスはMathです。");
            
            double num1 = 5.2;
            bw.write("日時 " + start_string + "開始");
            bw.newLine();
             bw.write(num1 + "を小数点切り上げすると" + Math.ceil(num1) + "です");
            bw.newLine();
            bw.write(num1 + "を小数点切り下げすると" + Math.floor(num1) + "です");
            bw.newLine();
            bw.write(num1 + "を四捨五入すると" + Math.round(num1) + "です");
            bw.newLine();
            bw.write("日時" + finish_string + "終了");
            bw.close();
            
    
            FileReader fr = new FileReader(name);                               //作成したログファイルを読み込む為にFileReaderをインスタンス化する。
            
            BufferedReader br = new BufferedReader(fr);                         //FileReaderの拡張機能としてBufferedReader(まとめて読む)をインスタンス化する。
            /*for(int i = 0; i<3; i++) {
                String line = br.readLine(); 
                out.print(line);
            }*/
            String line;                                                        //1行まとめて読むためのreadLineを定義する。
            while((line=br.readLine())!= null){
                out.println(line);
            }
            br.close();
           
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
}
