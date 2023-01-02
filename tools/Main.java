package tools;

import java.util.Scanner;

import daos.RegionDAO;
import daos.DivisionDAO;

import models.Region;
import models.Division;

public class Main {
    public void main(String[] args) {
        int menu, regionId, divisionId;
        String regionName, divisionName;
        Scanner scan = new Scanner(System.in);
        Scanner scans = new Scanner(System.in);

        do {
            System.out.println("\nMENU");
            System.out.println("1. View Regions");
            System.out.println("2. Insert Region");
            //System.out.println("3. Delete Regions");
            System.out.println("3. Update Region");
            //System.out.println("5. View Divisions");
            System.out.println("4. View Divisions");
            System.out.println("5. Insert Division");
            System.out.println("6. Delete Division");
            System.out.println("7. Update Division");
            System.out.println("0. Exit");
            System.out.print("Enter number: ");
            menu = scan.nextInt();

            if (menu == 1) {
                System.out.println("\nView Regions");
                getAllRegions();
            }
            else if (menu == 2) {
                System.out.println("\nInsert Region");
                getAllRegions();
                System.out.print("Enter Region Id: ");
                regionId = scan.nextInt();
                System.out.print("Enter Region Name: ");
                regionName = scans.nextLine();
                insertRegion(regionId, regionName);
            }
            // else if (menu == 3) {
            //     System.out.println("\nDelete Region");
            //     System.out.print("Enter Region Id: ");
            //     regionId = scan.nextInt();
            //     deleteRegion(regionId);
            // }
            else if (menu == 3) {
                System.out.println("\nUpdate Region's Name");
                getAllRegions();
                System.out.print("Enter Region Id: ");
                regionId = scan.nextInt();
                System.out.print("Enter New Region Name: ");
                regionName = scans.nextLine();
                updateRegion(regionId, regionName);
            }
            // else if (menu == 5) {
            //     System.out.println("\nView Divisions");
            //     getAllDivision();
            // }
            else if (menu == 4) {
                System.out.println("\nView Divisions");
                getAllDivisions();
            }
            else if (menu == 5) {
                System.out.println("\nInsert Division");
                getAllDivisions();
                System.out.print("Enter Division Id: ");
                divisionId = scan.nextInt();
                System.out.print("Enter Division Name: ");
                divisionName = scans.nextLine();
                getAllRegions();
                System.out.print("Enter Region Id: ");
                regionId = scan.nextInt();
                insertDivision(divisionId, divisionName, regionId);
            }
            else if (menu == 6) {
                System.out.println("\nDelete Division");
                getAllDivisions();
                System.out.print("Enter Division Id: ");
                divisionId = scan.nextInt();
                deleteDivision(divisionId);
            }
            else if (menu == 7) {
                System.out.println("\nUpdate Division");
                getAllDivisions();
                System.out.print("Enter Division Id: ");
                divisionId = scan.nextInt();
                System.out.print("Enter New Division Name: ");
                divisionName = scans.nextLine();
                getAllRegions();
                System.out.print("Enter New Id Region: ");
                regionId = scan.nextInt();
                updateDivision(divisionId, divisionName, regionId);
            }
            
        } while (menu !=0 );
  
         
    }

    public void getAllRegions(){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        for (Region region : rdao.getAll()) {
            System.out.print(region.getRegionId() + " ");
            System.out.println(region.getRegionName());
            
        }
        
    }

    public void insertRegion(int regionId, String regionName){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        Region region = new Region();
        region.setRegionId(regionId);
        region.setRegionName(regionName);
        System.out.println(rdao.insert(region));

    }

    public void deleteRegion(int regionId){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        Region region = new Region();
        region.setRegionId(regionId);
        System.out.println(rdao.delete(region));

    }

    public void updateRegion(int regionId, String regionName){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        Region region = new Region();
        region.setRegionId(regionId);
        region.setRegionName(regionName);
        System.out.println(rdao.update(region));

    }

    // public static void getAllDivision(){
    //     DbConnection connection = new DbConnection();
    //     //System.out.println(connection.getConnection());
    //     DivisionDAO ddao = new DivisionDAO(connection.getConnection());
    //     for (Division division : ddao.getAll()) {
    //         System.out.print(division.getDivisionId() + " ");
    //         System.out.print(division.getDivisionName() + " ");
    //         System.out.println(division.getRegionId());
            
    //     }
        
    // }

    public void getAllDivisions(){
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());
        DivisionDAO ddao = new DivisionDAO(connection.getConnection());
        for (Division division : ddao.getAll()) {
            System.out.print(division.getDivisionId() + " ");
            System.out.print(division.getDivisionName() + " ");
            System.out.println(division.getRegionName());
            
        }
        
    }
    public void insertDivision(int divisionId, String divisionName, int regionId){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        DivisionDAO ddao = new DivisionDAO(connection.getConnection());
        Division division = new Division();
        division.setDivisionId(divisionId);
        division.setDivisionName(divisionName);
        division.setRegionId(regionId);
        System.out.println(ddao.insert(division));

    }

    public void deleteDivision(int divisionId){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        DivisionDAO ddao = new DivisionDAO(connection.getConnection());
        Division division = new Division();
        division.setDivisionId(divisionId);
        System.out.println(ddao.delete(division));

    }

    public void updateDivision(int divisionId, String divisionName, int regionId){
        DbConnection connection = new DbConnection();
        //System.out.println(connection.getConnection());
        DivisionDAO rdao = new DivisionDAO(connection.getConnection());
        Division division = new Division();
        division.setDivisionId(divisionId);
        division.setDivisionName(divisionName);
        division.setRegionId(regionId);
        System.out.println(rdao.update(division));

    }
    
}
