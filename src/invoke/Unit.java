package invoke;


public class Unit {

    private String Name;
    private int HP;
    private int ATK;
    private boolean alive=true;

    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive=alive;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name=name;
    }

    public int getHP() {
        return HP;
    }
    public void setHP(int hp) {
        this.HP=hp;

    }

    public int getATK() {
        return ATK;
    }
    public void setATK(int atk) {
        this.ATK=atk;
    }
    public Unit(String Name,int HP,int ATK ,boolean alive) {
        this.Name=Name;
        this.HP=HP;
        this.ATK=ATK;
        this.alive=alive;
    }

    public void attack(Unit attacked,double factor) {
        Unit attacker=this;
        if(attacker.isAlive() && attacked.isAlive()) {
            System.out.println(attacker.getName()+"發起了攻擊");
            int damage=(int)Math.max(attacker.getATK()*factor,0);
            System.out.println(attacked.getName()+"受到了"+damage+"點傷害");
            attacked.setHP(Math.max(attacked.getHP()-damage, 0));
            if(attacked.getHP()<=0) {
                System.out.println(attacked.getName()+"倒下了");
                attacked.setAlive(false);
            }

        }else if(attacker.isAlive()==false) {
            System.out.println("攻擊者已經倒下");
        }else if(attacked.isAlive()==false) {
            System.out.println("被攻擊者已經倒下");
        }
    }

    public void recovery(int hp) {
        Unit unit=this;
        unit.setHP(unit.getHP()+hp);
        String s=unit.getName()+"增加"+hp+"點生命";
        System.out.println(s);
    }
}

