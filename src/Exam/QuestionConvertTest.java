package Exam;

import java.util.List;

//這是利用GsonFormat自動生成的,感覺上這個外掛一開始就是以讀取為目的,想將它轉化成get&set及建構子好像不太好用,
//蠻容易受bean的干擾


public class QuestionConvertTest {
    private List<QuestionBean> Questions;

    public List<QuestionBean> getQuestion() {
        return Questions;
    }

    public void setQuestion(List<QuestionBean> Questions) {
        this.Questions = Questions;
    }

    @Override
    public String toString() {
        return "QuestionConvertTest{" +
                "Questions=" + Questions +
                '}';
    }

    public static class QuestionBean {
        public QuestionBean(String ANS, String QID, String QDES, String NOTE, List<String> options) {
            this.ANS = ANS;
            this.QID = QID;
            this.QDES = QDES;
            this.NOTE = NOTE;
            Options = options;
        }

        /**
         * ANS : D
         * QID : 201
         * QDES : 常見的色彩模式有 RGB 及 CMYK 二種，有關兩者之描述何者有錯? 。
         * Option : [" R、G、B 分別代表紅色、綠色、藍色 ","RGB 模式色彩混合式為色加法，而 CMYK 模式則為色減法 ","色加去表示色彩越加越亮，如 RGB 三色等量混合後為白色 ","印刷輸出設備如彩色印表機通常採用 RGB 色彩模式。 ."]
         * NOTE : （294185 , 1則 , 有詳解）
         * (A) : 用 WAV 格式存
         * (B) : 用 mid 格式存
         * (C) : 用 gif 格式存
         * (D) : 用 jpg 格式存
         */

        private String ANS;
        private String QID;
        private String QDES;
        private String NOTE;
        private List<String> Options;

        public String getANS() {
            return ANS;
        }

        public void setANS(String ANS) {
            this.ANS = ANS;
        }

        public String getQID() {
            return QID;
        }

        public void setQID(String QID) {
            this.QID = QID;
        }

        public String getQDES() {
            return QDES;
        }

        public void setQDES(String QDES) {
            this.QDES = QDES;
        }

        public String getNOTE() {
            return NOTE;
        }

        public void setNOTE(String NOTE) {
            this.NOTE = NOTE;
        }

        public List<String> getOptions() {
            return Options;
        }

        public void setOption(List<String> Options) {
            this.Options = Options;
        }
    }
}