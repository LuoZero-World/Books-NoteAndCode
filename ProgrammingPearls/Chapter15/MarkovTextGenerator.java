package ProgrammingPearls.Chapter15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/*
 * 核心思想是构造后缀数组并排序，然后根据当前K个单词(M_phrase)查找到其在后缀数组中出现的起始位置
 * 然后使用取样算法选择一个与这K个单词匹配的后缀串，生成下一个单词
 */
public class MarkovTextGenerator {
    private static final int MAX_WORDS = 8000;
    private static final int K = 2; // 马尔可夫链阶数，即根据两个单词来生成下一个单词

    private String[] suffixArray = new String[MAX_WORDS]; // 存储后缀数组
    private int nWords = 0;                         // 记录单词数
    private String dataString;
    private String[] M_phrase = new String[K];

    public static void main(String[] args) {
        MarkovTextGenerator generator = new MarkovTextGenerator("Theres no doubt that my mother gives all her love to me. I do believe she is a great person who makes my life beautiful and meaningful. She is an easygoing and kind woman with bright eyes and a lovely smile. Although she is often busy, I still feel that I am taken good care of by her. Its a great pleasure to chat with her when I get into troubles. She always encourages me not to give up and tries to cheer me up by coming up with good solutions. In addition, I am fascinated by her cooking and writing. With her love, I feel like a fish swimming happily in a beautiful sea. I'll cherish her love forever.");
        
        generator.run();
    }

    MarkovTextGenerator(String dataString){
        this.dataString = dataString;
        Arrays.fill(suffixArray, "");
        //构造后缀数组
        buildSuffixArray();
    }

    public void run() {
        // 对后缀数组进行降序排序，因为有空串的存在，要将空串排在最后
        Arrays.sort(suffixArray, Comparator.reverseOrder());

        // 生成随机文本
        System.out.println("Generated Text:");
        generateRandomText(1000); // 生成 10000 个单词
    }

    private void buildSuffixArray() {
        String[] words = dataString.split("\\s+");
        nWords = words.length;

        //构造随机生成文本的初始短语
        for(int i = 0; i < K; i++) M_phrase[i] = words[i];

        // 构造以每个单词开头的后缀字符串
        int start = 0;
        for (int i = 0; i < nWords; i++) {
            suffixArray[i] = dataString.substring(start);
            start += words[i].length()+1; 
        }
    }

    /*
     * 根据前K个单词比较两个非空字符串，p是后缀数组，q是待比较串
     */
    private int wordNCompare(String p, String q) {
        int i = 0, j = 0;
        while (i < p.length() && j < q.length() && p.charAt(i) == q.charAt(j)) {
            i++;
            j++;
        }
        if(i >= p.length() || j >= q.length() && p.charAt(i) == ' ') return 0;
        return (i < p.length() ? p.charAt(i) : 0) - (j < q.length() ? q.charAt(j) : 0);
    }

    private void generateRandomText(int wordCount) {
        Random random = new Random();

        while (wordCount > 0) {
            int l = 0;
            int u = nWords;
            String selectedWord = null, phrase = String.join(" ", M_phrase);

            // 二分查找phrase第一次出现的位置
            while (l < u) {
                int m = (l + u) / 2;
                if (wordNCompare(suffixArray[m], phrase) > 0) {
                    l = m+1;
                } else {
                    u = m;
                }
            }

            // 查找匹配的后缀
            for (int i = 0; l+i < nWords && wordNCompare(suffixArray[l+i], phrase) == 0; i++) {
                //等概率生成 下一个单词
                if (random.nextInt(i + 1) == 0) {
                    selectedWord = suffixArray[l+i];
                }
            }

            if (selectedWord == null || selectedWord.length() < 1) break;
            String[] split = selectedWord.split("\s+");
            if(split.length <= K) break;
            selectedWord = split[K];

            M_phrase[0] = M_phrase[1];
            M_phrase[1] = selectedWord;

            System.out.print(selectedWord+" ");
            wordCount--;
        }
    }
}
