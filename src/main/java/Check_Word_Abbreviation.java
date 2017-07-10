/**
 * @author juntao zhang
 */
public class Check_Word_Abbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int num = 0;
        for (int i = 0, j = 0; i < word.length();) {
            //如果开头不是‘0’
            if (abbr.charAt(j) != '0') {
                //获取数字
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                if (num != 0) {
                    i += num;
                    if (i > word.length()) {
                        return false;
                    }
                    num = 0;
                    continue;
                }
            }
            if (word.charAt(i) != abbr.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(new Check_Word_Abbreviation().validWordAbbreviation("aaudrjtossfxxsgiuimqqblazarmwymxzaxxoiyjxdcqfgofqrgypuzqdavftqtzyeqglgnyyrxykwcfqozmgeylrdebgapgevllyzbsbiofnkdelicpajzrxkjfapmpturjfumygqrgmjkymnzzbcoieinlcecndbbpnerurlzmqvifaoobaqgmxxeftsztbnfeskrercftlvaeisqieldlsqlocbubjxbuebzmjcrsgrmrzwwbldgbtldvmexuenfrvenfjkikzlkogbrdbabdcydrpgcwasmgkpyslyabbriaewtnouskyzqztrtenljibcirvdnbjmfvgvcybvltzfdvoytslooxmmxtaofqbqokuemrgidgqcdnweotcyibxddbuvnfxkxaofzgasztgpicoetujkefuemarszrkvlurapduoonkoiyaidoggpfspfymwxzigkfsieiftzazdlcxskojyjnqcpafkoepfordwqxriiwocyoqiozmaxmqonuegefjwxpoiydbtmergdxcoaqlaxdjfdcoakcnjswunkvgztiyvztuabcmtescmogyqnpgevrxopjxdesyiclenetmpaplvmjcyekxnvkylckwmnayfxfctcjpssjyibsjeoogcklbujxjeessfidlagefljpjoxkowjokalmdmakamsesqfzdatxokwifmsfmxsplojcpygcccrlwpyetkbyfmkqlnrcqprmyalxjkowqctabryrmloswtrjvdufmjvtxyjezodbdxzuuswfbmpplypsjuafzalfwpspkrzkqxbicuwwzysbipugvtcyseexopxgdifcxjmdwwwwwwwwww", "2u852d10"));
        System.out.println(new Check_Word_Abbreviation().validWordAbbreviation("a", "1"));
    }
}
