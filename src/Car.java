import java.util.Scanner;
//Hashmap class of the util package is used to store the regions name corresponding to their region
import java.util.HashMap;
import java.util.Map;

//Implementation of enum for the region name
enum Regions{
    R1("USA"),R2("Europe"),R3("Asia"),R4("Africa");

    //variable to store the selected region name
    public String region_name;

    //Method for the Region
    Regions(String region_name){
        this.region_name=region_name;
    }

    //to get the region name
    public String getRegionName(){
        return region_name;
    }
}
public class Car{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        //Input to the system asking for the base price
        System.out.print("Enter the base price of the car: ");
        double price= sc.nextDouble();

        //Input asking the corresponding country
        System.out.print("Enter the country name: ");
        String name= sc.next();

        //Car Model Name
        System.out.print("Enter the car model: ");
        String model=sc.next();

        //type of fuel
        System.out.print("Enter the type of fuel: (Petrol/Diesel/LPG/CNG): ");
        String car_type=sc.next();

        //Mapping the countries with their regions
        Map<String, Regions> countryToRegion =new HashMap<>();
        countryToRegion.put("USA",Regions.R1);
        countryToRegion.put("Germany",Regions.R2);
        countryToRegion.put("India",Regions.R3);
        countryToRegion.put("Japan",Regions.R3);
        countryToRegion.put("Afghanistan",Regions.R3);
        countryToRegion.put("London",Regions.R2);
        countryToRegion.put("SouthAfrica",Regions.R4);
        countryToRegion.put("Angola",Regions.R4);
        countryToRegion.put("Nepal",Regions.R3);
        countryToRegion.put("Russia",Regions.R2);

        //object of the region method and setting up a default region if the input region is invalid
        Regions regions= countryToRegion.getOrDefault(name,Regions.R1);

        //Defining the tax rates for the diffrent regions
        final double Rate_R1=0.01;
        final double Rate_R2=0.02;
        final double Rate_R3=0.03;
        final double Rate_R4=0.02;

        double taxprice=0;
        switch(regions){
            case R1:
                taxprice= Rate_R1;
                System.out.printf("Tax Rate: %.2f%%%n",taxprice*100);
                break;

            case R2:
                taxprice= Rate_R2;
                System.out.printf("Tax Rate: %.2f%%%n",taxprice*100);
                break;

            case R3:
                taxprice= Rate_R3;
                System.out.printf("Tax Rate: %.2f%%%n",taxprice*100);
                break;

            case R4:
                taxprice= Rate_R4;
                System.out.printf("Tax Rate: %.2f%%%n",taxprice*100);
                break;

            default:
                System.out.println("Invalid Choice: ");
        }
        //calculates tax amount
        double taxAmount = price*taxprice;

        //calculates final price of the car including tax
        double finalPrice = price*taxAmount;

        System.out.printf("Region: %s (%s)%n" ,regions.name(),regions.getRegionName());
        System.out.print("Tax Amount: "+" "+taxAmount+"\n");
        System.out.printf("Final Price: %.2f%n",finalPrice);
    }
}
