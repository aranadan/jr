package com.javarush.test.level19.lesson03.task05;

import java.util.*;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution
{
    private static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static class DataAdapter implements RowItem{

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {

            String value = customer.getCountryName();
            String countryCode = "";
            Collection<String> collectionsKeys = (Collection) countries.keySet();
            for (String key : collectionsKeys){
                if (value.equals(countries.get(key))){
                    countryCode = key;
                }
            }
            return countryCode;

        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] array = contact.getName().split(", ");
            return array[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] array = contact.getName().split(", ");
            return array[0];
        }

        @Override
        public String getDialString()
        {
            String telNumber = contact.getPhoneNumber();
            String newFormatNumber;
            String callTo = "callto://";
            newFormatNumber = telNumber.replaceAll("[()-]","");
            return callTo + newFormatNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static void main(String[] args)
    {
        class Contacter implements Contact {

            @Override
            public String getName()
            {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber()
            {
                return "+38(050)123-45-67";
            }
        }

        class CustomerClass implements Customer {
            @Override
            public String getCompanyName()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName()
            {
                return "Ukraine";
            }
        }
        Contacter user = new Contacter();
        CustomerClass customer = new CustomerClass();
        DataAdapter da = new DataAdapter(customer,user);
        System.out.println(da.getCompany());
        System.out.println(da.getCountryCode());
        System.out.println(da.getContactFirstName());
        System.out.println(da.getContactLastName());
        System.out.println(da.getDialString());
    }
}