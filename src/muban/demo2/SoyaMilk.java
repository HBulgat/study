package muban.demo2;

public abstract class SoyaMilk {
    public final void make(){
        select();
        if(customerWantCondiment()){
            addCondiment();
        }
        soak();
        beat();
    }
    void select(){
        System.out.println("第一步：选择新鲜的豆子");
    }
    abstract void addCondiment();
    void soak(){
        System.out.println("第三步：豆子和配料开始浸泡");
    }
    void beat(){
        System.out.println("第四步：豆子和配料放入豆浆机榨汁");
    }
    //钩子方法：决定是否需要添加配料
    boolean customerWantCondiment() {
        return true;//默认情况下是要加配料的
    }
}
