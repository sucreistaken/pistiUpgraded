import java.util.Random;

public class ExpertBot extends Players {
    private String onBoard;
    public static boolean exbool = true;


    public ExpertBot(String name) {
        super(name + " Expert Bot");
    }
    @Override public String getOnBoard() {return onBoard;}
    @Override public void setOnBoard(String onBoard) {this.onBoard = onBoard;}
    public void PlayExpertBot(String[] args ) {
        Points pt = new Points();
        int score = pt.getTotalPointCards(Players.Board,args);
        System.out.println(getName() + " is playing... ");
        System.out.println();
        Random rd = new Random();
        int size = Board.size();
        if(size!=0) onBoard= Board.get(size-1);
        else onBoard=null;
        int random = rd.nextInt(getCards().size())+1;
        String cardNum = null;

        if(score>0){
            for (int i = 0; i < getCards().size(); i++) {
                if (getOnBoard().charAt(1) == getCards().get(i).charAt(1)) {
                    cardNum = getCards().get(i);
                    break;
                }
                else if(getCards().get(i).charAt(1)== 'J'){
                    cardNum=getCards().get(i);
                }
                else if (random == i + 1) {
                    for(int k=0; k< getCards().size();k++) {
                        String s = Counter.CheckCounts(getCards());
                        if (s != null){
                            cardNum = s;
                            break;
                        }
                        else {
                            cardNum = null;
                        }
                    }
                    Counter.play=null;
                    if(cardNum==null) {
                        cardNum = getCards().get(i);
                    }
                }
            }
            play(cardNum,args);
        }
        else{
            for (int i = 0; i < getCards().size(); i++) {
                if(getCards().get(i).charAt(1)!='J'){
                    while(getCards().get(random-1).charAt(1)=='J' ){
                        random = rd.nextInt(getCards().size()) + 1;
                    }
                }
            }
            cardNum=getCards().get(random-1);
            play(cardNum,args);
        }
    }
    @Override
    public void WhenWin(String cardNum,boolean misti,String[] args) {
      super.WhenWin(cardNum,misti,args);
    }
    @Override
    public void play(String cardNum,String[] args) {
        exbool =false;
        super.play(cardNum,args);
        exbool = true;
    }
}