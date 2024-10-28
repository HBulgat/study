package muban.demo2;

public class PureSoyaMilk extends SoyaMilk{
    @Override
    boolean customerWantCondiment(){
        return false;
    }
    @Override
    void addCondiment() {
    }
}
