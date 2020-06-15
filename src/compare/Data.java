package compare;

public class Data implements Comparable<Data> {
    private Object o;

    private final int IS_STRING = 1, IS_INTEGER = 2, IS_DOUBLE = 3;
    private int type;




    Data(int i) {
        this.o = i;
        type = IS_INTEGER;

    }

    Data(double d) {
        this.o = d;
        type = IS_DOUBLE;

    }

    Data(String s) {
        this.o = s;
        type = IS_STRING;

    }

    public int getType() {
        return type;
    }

    public Object getObject() {
        return o;
    }


    @Override
    public String toString() {
        return "Data{" +
                "o=" + o +
                '}';
    }


    @Override
    public int compareTo(Data data) {
        int typeValue = getType();

        if (typeValue == data.getType()) {//如果兩者屬性一致
            if (typeValue == 1) {//進行字串比較
                String s1 = (String) getObject();
                String s2 = (String) data.o;

                if (s1.compareTo(s2) < 0) {
                    return -1;
                } else if (s1.compareTo(s2) == 0) {
                    return 0;
                } else if (s1.compareTo(s2) > 0) {
                    return 1;
                }
            } else if (typeValue == 2) {//整數大小比較
                int i1 = (int) getObject();
                int i2 = (int) data.o;
                if (i1 < i2) {
                    return -1;
                } else if (i1 == i2) {
                    return 0;
                } else if (i1 > i2) {
                    return 1;
                }
            } else if (typeValue == 3) {//雙精數比較
                double d1 = (double) getObject();
                double d2 = (double) data.o;
                if (d1 < d2) {
                    return -1;
                } else if (d1 == d2) {
                    return 0;
                } else if (d1 > d2) {
                    return 1;
                }
            }


        } else if (typeValue < data.getType()) {
            return 1;
        } else {
            return -1;
        }

        /*if (isString) {
            String s1 = (String) getObject();
            String s2 = (String) data.o;

            if (s1.compareTo(s2) < 0) {
                return -1;
            } else if (s1.compareTo(s2) == 0) {
                return 0;
            } else if (s1.compareTo(s2) > 0) {
                return 1;
            }

        } else if (isInteger) {
            int i1 = (int) getObject();
            int i2 = (int) data.o;
            if (i1 < i2) {
                return -1;
            } else if (i1 == i2) {
                return 0;
            } else if (i1 > i2) {
                return 1;
            }

        } else if (isDouble) {

            double d1 = (double) getObject();
            double d2 = (double) data.o;
            if (d1 < d2) {
                return -1;
            } else if (d1 == d2) {
                return 0;
            } else if (d1 > d2) {
                return 1;
            }

        }*/
        return 0;

    }
}
