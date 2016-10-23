package com.example.a.calculator;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.StringBuilder;
//import java.util.function.LongToDoubleFunction;


public class MainActivity extends AppCompatActivity {

    class Stack<Item>{
        private Item[] a;
        private int N;
        public Stack(){
            a=(Item[]) new Object[1000];
        }
        public boolean isEmpty(){return N==0;}
        public int size()  {return N;}
        public void push(Item item){
            a[N++]=item;
        }
        public Item pop(){
            return a[--N];
        }


    }

    class Queue<Item>{
        private Node first;
        private Node last;
        private int n;

        private class Node{
            //定义了节点的嵌套类
            Item item;
            Node next;
        }

        public boolean isEmpty(){return first==null;}
        public int size() {return n;}
        public void enqueue(Item item){
            //向表尾添加元素
            Node oldlast=last;
            last=new Node();
            last.item=item;
            last.next=null;
            if(isEmpty()) first=last;
            else    oldlast.next=last;
            n++;
        }
        public Item dequeue(){
            Item item=first.item;
            first=first.next;
            if(isEmpty()) last=null;
            n--;
            return item;
        }
    }

    public static String Trans(double number, int ary, int accuracy)
    {
        int z = (int)number;
        double x = number - z;

        String r = "";

        for(;z>0;z/=ary)
            r = (char)(z%ary>9?z%ary+55:z%ary+48)+r;

        if(x != 0.0)
            r += '.';

        for(int i=0;i<accuracy&&x!=0.0;i++)
        {
            r += (char)((x*=ary)>9?x+55:x+48);
            x -= (int)x;
        }

        return r;
    }



    View vi;
    StringBuilder str=new StringBuilder(" ");
    String str1="";
    int flag=0;
    String result="";
    EditText ET;
    EditText ET2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //将按钮封装到数组中
        final Button func[]=new Button[10];
        final Button number[]=new Button[10];

        ET=(EditText)findViewById(R.id.editText);
        ET2=(EditText)findViewById(R.id.editText2);

        //数字按钮数组
        number[0]=(Button)findViewById(R.id.Btn_0);
        number[1]=(Button)findViewById(R.id.Btn_1);
        number[2]=(Button)findViewById(R.id.Btn_2);
        number[3]=(Button)findViewById(R.id.Btn_3);
        number[4]=(Button)findViewById(R.id.Btn_4);
        number[5]=(Button)findViewById(R.id.Btn_5);
        number[6]=(Button)findViewById(R.id.Btn_6);
        number[7]=(Button)findViewById(R.id.Btn_7);
        number[8]=(Button)findViewById(R.id.Btn_8);
        number[9]=(Button)findViewById(R.id.Btn_9);

        //功能按钮数组
        func[0]=(Button)findViewById(R.id.Btn_add);
        func[1]=(Button)findViewById(R.id.Btn_inc);
        func[2]=(Button)findViewById(R.id.Btn_muti);
        func[3]=(Button)findViewById(R.id.Btn_part);
        func[4]=(Button)findViewById(R.id.Btn_is);
        func[5]=(Button)findViewById(R.id.Btn_point);
        func[6]=(Button)findViewById(R.id.Btn_bin);
        func[7]=(Button)findViewById(R.id.Btn_clear);
        func[8]=(Button)findViewById(R.id.Btn_otc);
        func[9]=(Button)findViewById(R.id.Btn_hex);
        //事件

        number[0].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '0');
                    }else{
                        str.append('0');
                    }
                    str1 += '0';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '0');
                    }else{
                        str.append('0');
                    }
                    str1 += '0';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }
        });

        number[1].setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '1');
                    }else{
                        str.append('1');
                    }
                    str1 += '1';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '1');
                    }else{
                        str.append('1');
                    }
                    str1 += '1';
                    ET.setText(str);
                    ET2.setText(str1);
                }
                vi = v;
            }
        });

        number[2].setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '2');
                    }else{
                        str.append('2');
                    }
                    str1 += '2';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '2');
                    }else{
                        str.append('2');
                    }
                    str1+='2';
                    ET.setText(str);
                    ET2.setText(str1);
                }
                vi = v;
            }
        });

        number[3].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '3');
                    }else{
                        str.append('3');
                    }
                    str1 += '3';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '3');
                    }else{
                        str.append('3');
                    }
                    str1 += '3';
                    ET.setText(str);
                    ET2.setText(str1);
                }
                vi = v;
            }
        });

        number[4].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '4');
                    }else{
                        str.append('4');
                    }
                    str1 += '4';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '4');
                    }else{
                        str.append('4');
                    }
                    str1 += '4';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }
        });

        number[5].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '5');
                    }else{
                        str.append('5');
                    }
                    str1 += '5';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '5');
                    }else{
                        str.append('5');
                    }
                    str1 += '5';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }

        });

        number[6].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '6');
                    }else{
                        str.append('6');
                    }
                    str1 += '6';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '6');
                    }else{
                        str.append('6');
                    }
                    str1 += '6';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }

        });

        number[7].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '7');
                    }else{
                        str.append('7');
                    }
                    str1 += '7';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '7');
                    }else{
                        str.append('7');
                    }
                    str1 += '7';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }

        });

        number[8].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '8');
                    }else{
                        str.append('8');
                    }
                    str1 += '8';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '8');
                    }else{
                        str.append('8');
                    }
                    str1 += '8';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }

        });

        number[9].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (flag == 1) {
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '9');
                    }else{
                        str.append('9');
                    }
                    str1 += '9';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag = 0;
                    func[5].setEnabled(true);
                } else{
                    if(!str.equals("")) {
                        str.insert(str.length() - 1, '9');
                    }else{
                        str.append('9');
                    }
                    str1 += '9';
                    ET.setText(str);
                    ET2.setText(str1);

                }
                vi = v;
            }

        });

        //+事件代码
        func[0].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(flag==1){

                }else{
                    str.append("+@");
                    str1+='+';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag=1;
                }
            }

        });
        //-事件
        func[1].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag==1){

                }else{
                    str.append("-@");
                    str1+='-';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag=1;
                }
            }
        });
        //*事件
        func[2].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag==1){

                }else {
                    str.append("*#");
                    str1+='*';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag=1;
                }
            }
        });
        //÷事件
        func[3].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag==1){
                }else{
                    str.append("/#");
                    str1+='/';
                    ET.setText(str);
                    ET2.setText(str1);
                    //ET.setSelection();
                    flag=1;
                }
            }
        });
        //=事件
        func[4].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                    final Stack<Double> numStack = new Stack<Double>();
                    final Stack<Character> funcStack = new Stack<>();
                    final Queue<Character> linkTemp = new Queue<Character>();
                try {
                    String temp = String.valueOf(str);
                    int len = temp.length();
                    String temp1 = temp.replaceAll("@", "");
                    int times = len - temp1.length();
                    if (times <= 0) {
                    } else {
                        for (int i = 0; i < times; i++) {
                            str.append("#");
                        }
                    }
                    temp = String.valueOf(str);
                    char ch2[];
                    ch2 = temp.toCharArray();
                    String link = "";
                    char s = ' ';
                    for (int i = 0; i < ch2.length; i++) {
                        s = ch2[i];
                        if (s == ' ') ;
                        else if (s == '@') {
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";
                            }
                        } else if (s == '.') {
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";
                            }
                        } else if (s == '+') {
                            funcStack.push(s);
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";
                            }
                        } else if (s == '-') {
                            funcStack.push(s);
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";
                            }
                        } else if (s == '*') {
                            funcStack.push(s);
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";
                            }
                        } else if (s == '/') {
                            funcStack.push(s);
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";
                            }
                        } else if (s == 'p') {
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Math.pow(10, -size) * Double.parseDouble(link));
                                link = "";
                                double value = numStack.pop();
                                value = numStack.pop() + value;
                                numStack.push(value);
                            }
                        } else if (s == '#') {
                            //弹出字符和操作数
                            if (linkTemp.size() == 0) {
                            } else {
                                int size = linkTemp.size();
                                for (int a1 = 0; a1 < size; a1++) {
                                    link += linkTemp.dequeue();
                                }
                                if (!link.equals(""))
                                    numStack.push(Double.parseDouble(link));
                                link = "";

                            }
                            Character op = funcStack.pop();
                            double value = numStack.pop();
                            if (op == '+') value = numStack.pop() + value;
                            else if (op == '-') value = numStack.pop() - value;
                            else if (op == '*') value = numStack.pop() * value;
                            else if (op == '/') value = numStack.pop() / value;
                            //else if(op=='p')
                            numStack.push(value);
                        } else {
                            linkTemp.enqueue(s);
                        }
                    }
                    result=numStack.pop().toString();
                    str=new StringBuilder("").append(result).append('p');
                    str1=String.valueOf(result);
                    ET.setText(str);
                    ET2.setText(str1);
                    linkTemp.dequeue();
                   // numStack.push(Double.parseDouble(result));
                }catch(Exception e){
                }finally{
                }
            }
        });

        //小数点
        func[5].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag==1){

                }else{
                    str.append(".p");
                    str1+='.';
                    ET.setText(str);
                    ET2.setText(str1);
                    flag=1;
                    func[5].setEnabled(false);
                }
            }
        });

        //Binary
        func[6].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               String BinTemp=str1;
                double d=Double.valueOf(BinTemp);
                ET2.setText(Trans(d,2,3));
                str=new StringBuilder(" ");
                ET.setText(str);
                str1="";

            }
        });

        //清空
        func[7].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str.replace(0,str.length()," ");
                str1="";
                ET.setText(str);
                ET2.setText(str1);
                //flag=0;
                // numStack.destroy();
                //funcStack.destroy();
            }
        });
        //Otc
        func[8].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String BinTemp=str1;
                double d=Double.valueOf(BinTemp);
                ET2.setText(Trans(d,8,3));
                str=new StringBuilder(" ");
                ET.setText(str);
                str1="";


            }
        });
        //Hex
        func[9].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String BinTemp=str1;
                double d=Double.valueOf(BinTemp);
                ET2.setText(Trans(d,16,3));
                str=new StringBuilder(" ");
                ET.setText(str);
                str1="";
            }
        });
    }
}