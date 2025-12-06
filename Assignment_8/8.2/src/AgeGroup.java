public class AgeGroup {
    private int ageGroup;
    private int malePopulation;
    private int femalePopulaion;
    private int totalPopulation;

    public AgeGroup(String ageGroup, String malePopulation, String femalPopulation){
        this.ageGroup = Integer.parseInt(ageGroup);
        this.malePopulation = Integer.parseInt(malePopulation);
        this.femalePopulaion = Integer.parseInt(femalPopulation);
        addPopulations();
    }

    private void addPopulations(){
        totalPopulation = malePopulation + femalePopulaion;
    }

    @Override
    public String toString(){
        return String.format("%-5d%13d",ageGroup, totalPopulation);
    }
    
}
