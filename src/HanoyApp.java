import java.util.Stack;

public class HanoyApp {

    public static void main(String[] args) {
        Stack<Integer> pinStart = new Stack<>();
        Stack<Integer> pinFinish = new Stack<>();
        Stack<Integer> pinBuff = new Stack<>();


//        pinStart.push(7);
//        pinStart.push(6);
//        pinStart.push(5);
//        pinStart.push(4);
//        pinStart.push(3);
        pinStart.push(2);
        pinStart.push(1);

        System.out.println(pinStart);

        HanoyApp hanoyApp = new HanoyApp();
    //    hanoyApp.transfer(pinStart,pinFinish,pinBuff);
    //   hanoyApp.transferForThree(pinStart,pinFinish,pinBuff);
    //    hanoyApp.commonTransfer(pinStart,pinFinish,pinBuff);

        hanoyApp.solve(pinStart,pinBuff,pinFinish,pinStart.size());


        System.out.println();
       System.out.println(pinFinish);

    }

    private void transfer(Stack <Integer> pinStart, Stack <Integer> pinFinish, Stack <Integer> pinBuff){
        int firstEl;
        int middleEl;
        int lastEl;
        firstEl = pinStart.pop();
        pinFinish.push(firstEl);
        middleEl = pinStart.pop();
        pinBuff.push(middleEl);
        firstEl = pinFinish.pop();
        pinBuff.push(firstEl);
        lastEl = pinStart.pop();
        pinFinish.push(lastEl);
        firstEl = pinBuff.pop();
        middleEl = pinBuff.pop();
        pinFinish.push(middleEl);
        pinFinish.push(firstEl);
    }

    private void action (Stack <Integer> pinSource, Stack <Integer> pinTarget){
        int top = pinSource.pop();
        if (pinTarget.isEmpty()){
            pinTarget.push(top);
        } else {
            int check = pinTarget.peek();
            if (top < check) {
                pinTarget.push(top);
            } else {
                System.out.println("Ошибка");
            }
        }

    }

    private void transferForOne (Stack <Integer> pinStart, Stack <Integer> pinFinish, Stack <Integer> pinBuff){
        action(pinStart,pinFinish);
    }

    private void transferForTwo (Stack <Integer> pinStart, Stack <Integer> pinFinish, Stack <Integer> pinBuff){
        action(pinStart,pinBuff);
        action(pinStart,pinFinish);
        action(pinBuff,pinFinish);
    }

    private void transferForThree (Stack <Integer> pinStart, Stack <Integer> pinFinish, Stack <Integer> pinBuff){
        action(pinStart,pinFinish); // 1 - 3
        action(pinStart,pinBuff); // 1 - 2
        action(pinFinish,pinBuff); // 3 - 2
        action(pinStart,pinFinish); //1 - 3
        action(pinBuff,pinStart); //2 - 1
        action(pinBuff,pinFinish); //2 - 3
        action(pinStart,pinFinish); //1 - 3
    }

    private void commonTransfer(Stack <Integer> pinStart, Stack <Integer> pinFinish, Stack <Integer> pinBuff){
    while (pinStart.size()>3){
        System.out.println("зашли в цикл");
        System.out.println("стартовый штырь - "+pinStart);
        System.out.println("буферный штырь - "+pinBuff);
        System.out.println("финишный штырь - "+pinFinish);
        transferForThree(pinStart,pinBuff,pinFinish);//собрали три на буфер
        System.out.println("собрали три на буфер");
        System.out.println("стартовый штырь - "+pinStart);
        System.out.println("буферный штырь - "+pinBuff);
        System.out.println("финишный штырь - "+pinFinish);
        transferForOne(pinStart,pinFinish,pinBuff); //убрали элемент на финиш
        System.out.println("убрали верхний элемент со старта на финиш");
        System.out.println("стартовый штырь - "+pinStart);
        System.out.println("буферный штырь - "+pinBuff);
        System.out.println("финишный штырь - "+pinFinish);
        transferForThree(pinBuff,pinFinish,pinStart); //смонтировали три на финиш
        System.out.println("смонтировали три на финиш");
        System.out.println("стартовый штырь - "+pinStart);
        System.out.println("буферный штырь - "+pinBuff);
        System.out.println("финишный штырь - "+pinFinish);
    }
        System.out.println("Закончили");
        System.out.println("стартовый штырь - "+pinStart);
        System.out.println("буферный штырь - "+pinBuff);
        System.out.println("финишный штырь - "+pinFinish);
    }


    private void solve (Stack <Integer> pinStart, Stack <Integer> pinBuff, Stack <Integer> pinFinish, int count){
        if (count>0){
            solve(pinStart,pinFinish,pinBuff,count-1);
            int main = pinStart.pop();
            pinFinish.push(main);
            solve(pinBuff,pinStart,pinFinish,count-1);
        }
    }


}
