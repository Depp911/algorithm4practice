package com.jayne.book;

import com.jayne.util.StdIn;
import com.jayne.util.StdOut;

/**
 * Dijkstra的双栈算术表达式求职算法
 *
 * Created by Jayne on 2018/12/19.
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if("(".equals(s)){
                //忽略
            }else if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "sqrt".equals(s)){
                ops.push(s);
            }else if(")".equals(s)){
                String op = ops.pop();
                double v = vals.pop();
                if("+".equals(op)){
                    v = vals.pop() + v;
                }else if("-".equals(op)){
                    v = vals.pop() - v;
                }else if("*".equals(op)){
                    v = vals.pop() * v;
                }else if("/".equals(op)){
                    v = vals.pop() / v;
                }else if("sqrt".equals(op)){
                    v = Math.sqrt(v);
                }
                vals.push(v);
            }else {
                //数据直接入栈
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.printf("result: %.2f", vals.pop());
    }
}
