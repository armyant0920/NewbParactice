package Example;

class StaticClass {

    MyMessage myMessage;



    static class MyMessage{
        public int num=100;
        public String myText="";

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getMyText() {
            return myText;
        }

        public void setMyText(String myText) {
            this.myText = myText;
        }

        @Override
        public String toString() {
            return "myNum{" +
                    "num=" + num +
                    ", myText='" + myText + '\'' +
                    '}';
        }
    }
}
