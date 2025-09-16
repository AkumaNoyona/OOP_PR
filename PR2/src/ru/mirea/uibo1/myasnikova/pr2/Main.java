package ru.mirea.uibo1.myasnikova.pr2;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();

        Author author1 = new Author("Толстой Лев Николаевич");
        Author author2 = new Author("Джорж Байрон", "jb@gmail.com", 'M', 37);

        System.out.println("\nАвтор: "+ author);
        author.setName("Марк Твен");
        author.setEmail("twen@yandex.ru");
        author.setAge(56);
        author.setGender('m');
        System.out.println("\nАвтор: "+ author);
        System.out.println("My favorite author: " + author.getName());
    }
}