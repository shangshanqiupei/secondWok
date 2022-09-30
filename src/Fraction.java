public class Fraction {
    private int molecule;
    private int denominator; //定义分子分母

    public Fraction() {

    }

    public Fraction(int i, int j) {
        this.molecule = molecule;
        this.denominator = denominator;
    }
    /**
     * 生成随机分数
     * @param max
     * @return
     */
    public static Fraction newFraction(int max){
        int denominator = (int)(Math.random()*max);
        if(denominator==0){
            denominator+=1;
        }
        int molecule = (int)(Math.random()*(denominator*max));
        if(molecule==0){
            molecule+=1;
        }
        Fraction fraction = new Fraction();
        fraction.setMolecule(molecule);
        fraction.setDenominator(denominator);
        return fraction;
    }

    /**
     * 按照Fraction的string形式生成Fraction对象
     * @param frationToString
     */
    public Fraction(String frationToString){
        if(!frationToString.contains("/")){
            int num = Integer.parseInt(frationToString);
            this.denominator=1;
            this.molecule=num;
        }
        else if(!frationToString.contains("'")){
            int separator = frationToString.indexOf("/");
            this.molecule = Integer.parseInt(frationToString.substring(0,separator));
            this.denominator = Integer.parseInt(frationToString.substring(separator+1,frationToString.length()));
        }
        else {
            int separatorOne = frationToString.indexOf("'");
            int separatorTwo = frationToString.indexOf("/");
            this.denominator = Integer.parseInt(frationToString.substring(separatorTwo+1,frationToString.length()));
            int prefix = Integer.parseInt(frationToString.substring(0,separatorOne));
            int fakeMolecule = Integer.parseInt(frationToString.substring(separatorOne+1,separatorTwo));
            this.molecule = prefix*denominator+fakeMolecule;
        }
    }
    /**
     * 将分数对象按真分数的表示方法打印
     *
     * @return String
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            return molecule + "";
        } else {
            int prefix = molecule / denominator;
            int realMolecule = molecule % denominator;
            if (realMolecule == 0) {
                return prefix + "";
            }
            //拿分子分母的最小公因数
            int commonFactor = Math.abs(getCommonFactor(denominator, realMolecule));
            if (prefix == 0) {
                return realMolecule / commonFactor + "/" + denominator / commonFactor;
            } else
                return prefix + "'" + realMolecule / commonFactor + "/" + denominator / commonFactor;
        }
    }
    /*
    寻找a,b最大公约数
     */
    private int getCommonFactor(int a,int b){
        int c = a % b;
        if(c==0)return b;
        else{
            return getCommonFactor(b,c);
        }
    }
    public static Fraction intChangeToFraction(int num){
        Fraction fraction = new Fraction();
        fraction.setDenominator(1);
        fraction.setMolecule(num);
        return fraction;
    }


    /**
     * 加法
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction add(Fraction fractionA,Fraction fractionB) {
        Fraction fraction = new Fraction();
        int molecule = fractionA.molecule * fractionB.denominator +
                fractionB.molecule * fractionA.denominator;
        int denominator = fractionA.denominator * fractionB.denominator;
        fraction.setMolecule(molecule);
        fraction.setDenominator(denominator);
        return fraction;
    }

    /**
     * 减法
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction subtraction(Fraction fractionA,Fraction fractionB){
        Fraction fraction = new Fraction();
        int molecule = fractionA.molecule * fractionB.denominator -
                fractionB.molecule * fractionA.denominator;
        int denominator = fractionA.denominator * fractionB.denominator;
        fraction.setMolecule(molecule);
        fraction.setDenominator(denominator);
        return fraction;
    }

    /**
     * 乘法
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction multiplication(Fraction fractionA,Fraction fractionB){
        Fraction fraction = new Fraction();
        int molecule = fractionA.molecule * fractionB.molecule;
        int denominator = fractionA.denominator * fractionB.denominator;
        fraction.setMolecule(molecule);
        fraction.setDenominator(denominator);
        return fraction;
    }

    /**
     * 除法
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction division(Fraction fractionA,Fraction fractionB) throws Exception {
        if(fractionB.molecule==0){
            throw new Exception("除数为0");
        }
        Fraction fraction = new Fraction();
        int molecule = fractionA.molecule * fractionB.denominator;
        int denominator = fractionA.denominator * fractionB.molecule;
        fraction.setMolecule(molecule);
        fraction.setDenominator(denominator);
        return fraction;
    }



































    public int getMolecule() {
        return molecule;
    }

    public void setMolecule(int molecule) {
        this.molecule = molecule;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
