package Exer;

import java.math.BigDecimal;

/**
 * Created by menghan on 2017/10/18.
 */
public class ADC {
    public static void main(String[] args) {
        System.out.println(solution("0 200"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(" ");
        // 返回处理后的结果
        int level = Integer.parseInt(strs[0]);
        int armor = Integer.parseInt(strs[1]);
        int axeArmor = armor-(100+10*level);
        double bowArmor = 0.55*armor;
        double axeDmgReduce = (double)axeArmor/(axeArmor+602);
        double bowDmgreduce = bowArmor/(bowArmor+602);
        double axeDmg = 185*(1-axeDmgReduce);
        double bowDmg = 180*(1-bowDmgreduce);
        BigDecimal axe = new BigDecimal(axeDmg);
        BigDecimal bow = new BigDecimal(bowDmg);
        return axe.compareTo(bow)>0?"axe":(axe.compareTo(bow)==0?"same":"bow");
    }
}
