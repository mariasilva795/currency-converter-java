package Main;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.*;

import Records.Currency;
//import Services.CurrencyHistoryManager;
import Services.CurrencyHistoryManager;
import Services.CurrencyServices;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.google.gson.Gson;
import views.CurrencyHistoryView;
import views.MainScreen;

public class Main {

    private static final String API_KEY = "c6b78493c77b8545bd8c3d70";
    public static void  main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        CurrencyHistoryView historyView = new CurrencyHistoryView();
        CurrencyHistoryManager historyManager = new CurrencyHistoryManager();

        Scanner sc = new Scanner(System.in);
        int option = 0;
        try {
            while (option != 9) {
                System.out.println("""
                    ************************************************************
                    ********** WELCOME TO CONVERT CURRENCY **********
                    ************************************************************
                    
                    ********** SELECT OPERATION THAT YOU WANT TO PERFORM**********
                    1 - Make currency conversion
                    2 - Review currency conversion historial
                    9 - Quit of currency conversion
                    """);
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        mainScreen.showMainScreen(historyManager);
                        break;
                    case 2:

                        if(historyManager.getHistory().isEmpty()){
                            System.out.println("Empty List");
                        }else {
                            historyView.show(historyManager.getHistory());
                            break;
                        }
                    case 9:
                        System.out.println("Thank you for using our conversion system!");
                }
            }
        } catch (InputMismatchException e){
            System.out.println("You must add a number to the menu");
        } catch(IndexOutOfBoundsException e){
            System.out.printf("Select a number from an available currency from the list");
        } catch(RuntimeException e){
            System.out.println("Try again");
        } finally{
            System.out.println("End execution");
        }
    }


}
