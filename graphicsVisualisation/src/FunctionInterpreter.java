import java.util.*;

class FunctionInterpreter {

    ArrayList<String> post;

    FunctionInterpreter(String Func) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("(");

        String[] ar = new String[1];

        ar = (Func + " ").split(" ");

        String f = "";

        for (int i = 0; i < ar.length; i++) {
            f = f + ar[i];
        }

        ar = f.split("");
        int ind = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equals("+") | ar[i].equals("-") | ar[i].equals("*") | ar[i].equals("/") | ar[i].equals("(") | ar[i].equals(")") | ar[i].equals("^")) {

                String s = "";
                for (int j = ind; j < i; j++) {
                    s = s + ar[j];
                }
                list.add(s);
                list.add(ar[i]);
                ind = i + 1;
            } else {
                if ((i + 2) < ar.length) {
                    if ((ar[i] + ar[i + 1] + ar[i + 2]).equals("sin") | (ar[i] + ar[i + 1] + ar[i + 2]).equals("cos") | (ar[i] + ar[i + 1] + ar[i + 2]).equals("ctg")) {
                        list.add(ar[i] + ar[i + 1] + ar[i + 2]);
                        i = i + 2;
                        ind = i + 1;
                    }
                } else {
                    if ((i + 1) < ar.length) {
                        if ((ar[i] + ar[i + 1]).equals("tg") | (ar[i] + ar[i + 1]).equals("ln") | (ar[i] + ar[i + 1]).equals("lg") | (ar[i] + ar[i + 1]).equals("Pi")) {
                            list.add(ar[i] + ar[i + 1] + ar[i + 2]);
                            i = i + 1;
                            ind = i + 1;
                        }
                    }
                }
            }
        }

        String s = "";
        for (int j = ind; j < ar.length; j++) {
            s = s + ar[j];
        }
        list.add(s);

        int q = 0;
        while (q == 0) {
            q = 1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("")) {
                    list.remove(i);
                    q = 0;
                }
            }
        }

        q = 0;
        while (q == 0) {
            q = 1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("-")) {
                    if (list.get(i - 1).equals("(")) {
                        list.remove(i);
                        list.add(i, "-1");
                        list.add(i + 1, "*");
                        q = 0;
                    }
                }
            }
        }

        post = new ArrayList<String>();
        ArrayList<String> stack = new ArrayList<String>();
        stack.add("");
        list.add(")");
        list.add("?");


        int i = 0;
        while (!list.get(i).equals("?")) {

            if (list.get(i).equals("(")) {
                stack.add("(");
                i++;
            } else if (list.get(i).equals("*") | list.get(i).equals("/")) {
                if (stack.get(stack.size() - 1).equals("*") | stack.get(stack.size() - 1).equals("/")) {
                    post.add(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(list.get(i));
                    i++;
                }
            } else if (list.get(i).equals("+") | list.get(i).equals("-")) {
                if (stack.get(stack.size() - 1).equals("(")) {
                    stack.add(list.get(i));
                    i++;
                } else {
                    post.add(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                }
            } else if (list.get(i).equals(")")) {
                while (!stack.get(stack.size() - 1).equals("(")) {
                    post.add(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                }
                i++;
                stack.remove(stack.size() - 1);
            } else if (list.get(i).equals("^") | list.get(i).equals("sin") | list.get(i).equals("cos") | list.get(i).equals("tg") | list.get(i).equals("ctg") | list.get(i).equals("lg") | list.get(i).equals("ln")) {
                stack.add(list.get(i));
                i++;
            } else {
                post.add(list.get(i));
                i++;
            }

        }

        q = 0;
        while (q == 0) {
            q = 1;
            for (i = 0; i < post.size(); i++) {
                if (post.get(i).equals("")) {
                    post.remove(i);
                    q = 0;
                }
            }
        }

    }

    Double alg(double x) {
        ArrayList<Double> stack = new ArrayList<Double>();

        for (int i = 0; i < post.size(); i++) {
            if (post.get(i).equals("+")) {
                double n = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("-")) {
                double n = stack.get(stack.size() - 2) - stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("*")) {
                double n = stack.get(stack.size() - 2) * stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("/")) {
                double n = stack.get(stack.size() - 2) / stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("^")) {
                double n = Math.pow(stack.get(stack.size() - 2), stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("x") | post.get(i).equals("X")) {
                stack.add(x);
            } else if (post.get(i).equals("sin")) {
                double n = Math.sin(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("cos")) {
                double n = Math.cos(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("tg")) {
                double n = Math.tan(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("ctg")) {
                double n = Math.cos(stack.get(stack.size() - 1)) / Math.sin(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("ln")) {
                double n = Math.log(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("lg")) {
                double n = Math.log10(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
                stack.add(n);
            } else if (post.get(i).equals("Pi") | post.get(i).equals("pi")) {
                stack.add(Math.PI);
            } else if (post.get(i).equals("e") | post.get(i).equals("E")) {
                stack.add(Math.E);
            } else {
                stack.add(Double.parseDouble(post.get(i)));
            }


        }
        double y = stack.get(0);
        return y;
    }
}