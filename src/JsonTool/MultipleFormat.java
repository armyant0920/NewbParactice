package JsonTool;

import java.util.List;

public class MultipleFormat {


    /**
     * ANS : D
     * QID : 201
     * QDES : 常見的色彩模式有 RGB 及 CMYK 二種，有關兩者之描述何者有錯? 。
     * Option : [" R、G、B 分別代表紅色、綠色、藍色 ","RGB 模式色彩混合式為色加法，而 CMYK 模式則為色減法 ","色加去表示色彩越加越亮，如 RGB 三色等量混合後為白色 ","印刷輸出設備如彩色印表機通常採用 RGB 色彩模式。 ."]
     * NOTE : （294185 , 1則 , 有詳解）
     */

    private String ANS;
    private String QID;
    private String QDES;
    private String NOTE;
    private List<String> Option;

    @Override
    public String toString() {
        return "MultipleFormat{" +
                "ANS='" + ANS + '\'' +
                ", QID='" + QID + '\'' +
                ", QDES='" + QDES + '\'' +
                ", NOTE='" + NOTE + '\'' +
                ", Option=" + Option +
                '}';
    }

    public MultipleFormat(String ANS, String QID, String QDES, String NOTE, List<String> option) {
        this.ANS = ANS;
        this.QID = QID;
        this.QDES = QDES;
        this.NOTE = NOTE;
        Option = option;
    }

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

    public List<String> getOption() {
        return Option;
    }

    public void setOption(List<String> Option) {
        this.Option = Option;
    }


}
