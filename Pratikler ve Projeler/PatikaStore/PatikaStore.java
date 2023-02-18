import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatikaStore
{
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args)
    {
        Brand.brands.add(new Brand(1,"Samsung"));
        Brand.brands.add(new Brand(2,"Lenova"));
        Brand.brands.add(new Brand(3,"Apple"));
        Brand.brands.add(new Brand(4,"Huawei"));
        Brand.brands.add(new Brand(5,"Casper"));
        Brand.brands.add(new Brand(6,"Asus"));
        Brand.brands.add(new Brand(7,"HP"));
        Brand.brands.add(new Brand(8,"Xiaomi"));
        Brand.brands.add(new Brand(9,"Monster"));

        Notebook nb1=new Notebook(1,"HUAWEI Matebook 14",7000,10,0, Brand.brands.get(3),"",16,512,14);
        Notebook.notebooks.add(nb1);
        Notebook nb2=new Notebook(2,"LENOVA V14 IGL",3699,10,0, Brand.brands.get(1),"",8,1024,14);
        Notebook.notebooks.add(nb2);
        Notebook nb3=new Notebook(3,"ASUS Tuf Gaming",8199,10,0, Brand.brands.get(5),"",32,2048,15.6);
        Notebook.notebooks.add(nb3);
        CellPhone ph1=new CellPhone(1,"SAMSUNG GALAXY A51",3199,10,0, Brand.brands.get(0),"Siyah",128,6,6.5,4000);
        CellPhone.cellPhones.add(ph1);
        CellPhone ph2=new CellPhone(2,"Iphone 11 64 GB",7379,10,0, Brand.brands.get(2),"Mavi",64,6,6.1,3046);
        CellPhone.cellPhones.add(ph2);
        CellPhone ph3=new CellPhone(3,"Redmi Note 10 Pro 8GB",4012,10,0, Brand.brands.get(8),"Beyaz",128,12,6.5,4000);
        CellPhone.cellPhones.add(ph3);

        while (!quit)
        {
            showMenu();
            int select=selectOption();
            showChoice(select);
        }

    }
    static boolean quit=false;
    public static void getBrands(List<Brand> brands)
    {
        Collections.sort(brands);

        for(Brand b:brands)
            System.out.println(b.getBrandName());
    }
    public static void sortProducts(List<Product> products)
    {
        Collections.sort(products);
    }
    public static void showProducts(List<Product> products,int control)
    {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        if(control==1)
        {
            System.out.println("| ID |      Ürün Adı            |   Fiyat      |  Marka       |  Depolama   |  Ekran    |    Ram     |");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            for(Product p:products)
            {
                System.out.println("| "+ p.getProductId() +"  |   "+p.getProductName()+"        |    "+p.getProductPrice()+" TL   |   "+p.getBrand().getBrandName()+"       |   "+Notebook.getStorage()+"      | "+Notebook.getScreenSize()+"      | "+Notebook.getRam() +"    |");
            }

        }
        else if(control==2)
        {
            System.out.println("| ID |      Ürün Adı            |   Fiyat      |  Marka       |  Depolama   |  Ekran    |  Ram  |  Pil       |");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for(Product p:products)
            {
                System.out.println("| "+ p.getProductId() +"  |   "+p.getProductName()+"       |   "+p.getProductPrice()+" TL   |   "+p.getBrand().getBrandName()+"     |   "+CellPhone.getStorage()+"     | "+CellPhone.getScreenSize()+"      | "+CellPhone.getRam() +"     | "+ CellPhone.getBatteryPower()+    "       |");
            }

        }
        else
            System.out.println("Bir hata oldu!");



    }
    public static void showMenu()
    {
        String[] productsType=Product.productsList;
        System.out.println("\nPatikaStore Ürün Yönetim Paneli !\n");
        for(int i=0;i<productsType.length;i++)
        {
            System.out.println((i+1)+" - "+ productsType[i] +" işlemleri");
        }
        System.out.println((productsType.length+1)+" - Marka Listele\n0 - Çıkış Yap");
    }
    public static int selectOption()
    {
        System.out.print("\nTercihiniz : ");
        return input.nextInt();
    }
    public static void askData(int control)
    {
        System.out.print("Ürün İsmi : ");
        String name=input.next();
        System.out.print("Ürün Fiyatı : ");
        int price=input.nextInt();
        System.out.print("Ürün Stoğu : ");
        int stock=input.nextInt();
        System.out.print("İndirim Oranı : ");
        double disc=input.nextDouble();
        System.out.print("Rengi : ");
        String color= input.next();
        System.out.print("Ram : ");
        int ram=input.nextInt();
        System.out.print("Hafıza Boyutu : ");
        int storage=input.nextInt();
        System.out.print("Ekran Boyutu : ");
        double sSize=input.nextDouble();
        System.out.println("\nÜrün Markası Seçiniz : ");
        getBrands(Brand.brands);
        int brandNumber=input.nextInt();

        if(control==1)
            Notebook.addNotebook(name,price,stock,disc,Brand.brands.get(brandNumber),color,ram,storage,sSize);
        else if(control==2)
        {
            System.out.println("Batarya Kapasitesi : ");
            int batteryCap=input.nextInt();
            CellPhone.addCellPhone(name,price,stock,disc,Brand.brands.get(brandNumber),color,ram,storage,sSize,batteryCap);
        }
        else
            System.out.println("Bir hata oldu!");
    }
    public static void findProduct(int control)
    {
        System.out.println("\nAradığınız ürün adını eksiksiz giriniz : ");
        input.nextLine();
        String name=input.nextLine();
        if(control==1)
        {
            for(Product p:Notebook.notebooks)
            {
                if(name.equals(p.getProductName()))
                {
                    System.out.println("| ID |      Ürün Adı            |   Fiyat      |  Marka       |  Depolama   |  Ekran    |  Ram  |");
                    System.out.println("| "+ p.getProductId() +"  |   "+p.getProductName()+"        |    "+p.getProductPrice()+" TL   |   "+p.getBrand().getBrandName()+"       |   "+Notebook.getStorage()+"      | "+Notebook.getScreenSize()+"      | "+Notebook.getRam() +"    |");
                }
            }
        }
        else if(control==2)
        {
            for(Product p:CellPhone.cellPhones)
            {
                if((p.getProductName()).equals(name))
                {
                    System.out.println("| ID |      Ürün Adı            |   Fiyat      |  Marka       |  Depolama   |  Ekran    |  Ram  |  Pil       |");
                    System.out.println("| "+ p.getProductId() +"  |   "+p.getProductName()+"       |   "+p.getProductPrice()+" TL   |   "+p.getBrand().getBrandName()+"     |   "+CellPhone.getStorage()+"     | "+CellPhone.getScreenSize()+"      | "+CellPhone.getRam() +"     | "+ CellPhone.getBatteryPower()+    "       |");
                }
            }
        }
        else
            System.out.println("Bir hata oldu ğğğ");
    }
    public static void deleteProduct(int control)
    {
        System.out.print("\nSilinecek Ürünün ID adresini giriniz : ");
        int productId=input.nextInt();
        if(control==1)
        {
            for(Product p:Notebook.notebooks)
            {
                if(p.getProductId()==productId)
                {
                    Notebook.notebooks.remove(p);
                    break;
                }
            }
        }
        else if(control==2)
        {
            for(Product p:CellPhone.cellPhones)
            {
                if(p.getProductId()==productId)
                {
                    CellPhone.cellPhones.remove(p);
                    break;
                }
            }
        }
        else
            System.out.println("Bir hata oldu!");
    }
    public static void showChoice(int key)
    {
        switch (key)
        {
            case 1:
                switch (showMenu2())
                {
                    case 1:
                        switch (showMenu3())
                        {
                            case 1:
                                Product.key=1;
                                sortProducts(Notebook.notebooks);
                                showProducts(Notebook.notebooks,1);
                                break;
                            case 2:
                                Product.key=2;
                                sortProducts(Notebook.notebooks);
                                showProducts(Notebook.notebooks,1);
                                break;
                            case 3:
                                Product.key=3;
                                sortProducts(Notebook.notebooks);
                                showProducts(Notebook.notebooks,1);
                                break;
                            default:
                                System.out.println("Bir hata oldu!");
                                break;
                        }
                        break;
                    case 2:
                        askData(1);
                        showProducts(Notebook.notebooks,1);
                        break;
                    case 3:
                        showProducts(Notebook.notebooks,1);
                        deleteProduct(1);
                        break;
                    case 4:
                        findProduct(1);
                        break;
                    default:
                        System.out.println("Bir hata oldu!");
                        break;
                }
                break;
            case 2:
                switch(showMenu2())
                {
                    case 1:
                        switch(showMenu3())
                        {
                            case 1:
                                Product.key=1;
                                sortProducts(CellPhone.cellPhones);
                                showProducts(CellPhone.cellPhones,2);
                                break;
                            case 2:
                                Product.key=2;
                                sortProducts(CellPhone.cellPhones);
                                showProducts(CellPhone.cellPhones,2);
                                break;
                            case 3:
                                Product.key=3;
                                sortProducts(CellPhone.cellPhones);
                                showProducts(CellPhone.cellPhones,2);
                                break;
                            default:
                                System.out.println("Bir hata oldu!");
                                break;
                        }
                        break;
                    case 2:
                        askData(2);
                        showProducts(CellPhone.cellPhones,2);
                        break;
                    case 3:
                        showProducts(CellPhone.cellPhones,2);
                        deleteProduct(2);
                        break;
                    case 4:
                        findProduct(2);
                        break;
                    default:
                        System.out.println("Bir hata oldu!");
                        break;
                }
                break;
            case 3:
                System.out.println("\nMarkalarımız \n------------");
                getBrands(Brand.brands);
                break;
            case 0:
                System.out.println("Görüşmek Üzere...");
                quit=true;
                break;
        }
    }
    public static int showMenu2()
    {
        System.out.println("-Yapılabilecek İşlemler-");
        System.out.println("\n1-Ürünleri Listele\n2-Ürün Ekle\n3-Ürün Sil\n4-Ürün Ara");
        return selectOption();

    }
    public static int showMenu3()
    {
        System.out.println("\n1-ID'ye göre sırala");
        System.out.println("2-İsme göre sırala");
        System.out.println("3-Markaya göre sırala");
        return selectOption();
    }

}