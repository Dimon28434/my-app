package com.example.my_app;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> historyQuestions () {

        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Який історичний поділ України на дві частини стався в 17 столітті?",
                "a) Поділ за рікою Дніпро", "b) Поділ за лінією Збруча", "c) Поділ за лініє", "d) Поділ за лінією Дністра",
                "b) Поділ за лінією Збруча", "");

        final QuestionsList question2 = new QuestionsList("Яка з наступних осіб була першою королевою України?",
                "a) Ольга", "b) Любов", "d) Роксолана", "d) Катя",
                "a) Ольга", "");

        final QuestionsList question3 = new QuestionsList("Коли відбувся Євромайд",
                "a) 2004 рік", "b) 2014 рік", "c) 1991 рік", "d) 2020 рік",
                "b) 2014 рік", "");

        final QuestionsList question4 = new QuestionsList("Хто був першим князем Київської Русі?",
                "a) Ігор", "b) Олег", "c) Володимир", "d) Рюрик",
                "d) Рюрик", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        return questionsList;
    }

    private static List<QuestionsList> literatureQuestions () {

        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Хто є автором твору \"Кобзар\"?",
                "a) Іван Франко", "b) Леся Українка", "c) Тарас Шевченко", "d) Іван Котляревський",
                "c) Тарас Шевченко", "");

        final QuestionsList question2 = new QuestionsList("Яка поезія Тараса Шевченка вважається його головною збіркою?",
                "a) \"Заповіт\"", "b) \"Катерина\"", "d) \"Кавказ\"", "d) \"Кобзар\"",
                "a) Ольга", "");

        final QuestionsList question3 = new QuestionsList("Яка з романтичних поезій Лесі Українки стала особливо популярною?",
                "a) \"Лісова пісня\"", "b) \"Камін\"", "c) \"Сон\"", "d) \"Стоїть явір\"",
                "a) \"Лісова пісня\"", "");

        final QuestionsList question4 = new QuestionsList("З якого часу починається українська література?",
                "a) Із середньовіччя", "b) Із нового часу", "c)  Із ХІХ століття", "d) Із ХХ століття",
                "a) Із середньовіччя", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        return questionsList;
    }

    private static List<QuestionsList> geographyQuestions () {

        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Який гірський хребет розташований на заході України?",
                "a) Карпати", "b) Кримські гори", "c) Волинські височини", "d) Дніпровські височини",
                "a) Карпати", "");

        final QuestionsList question2 = new QuestionsList("Яка річка є найбільшою за довжиною на території України?",
                "a) Дніпро", "b) Дунай", "d) Десна", "d) Дністер",
                "а) Дніпро", "");

        final QuestionsList question3 = new QuestionsList("Яке місто є столицею України?",
                "a) Львів", "b) Харків", "c) Одеса", "d) Київ",
                "d) Київ", "");

        final QuestionsList question4 = new QuestionsList("Які великі водойми знаходяться на півдні України?",
                "a) Чорне море та Азовське море", "b) Балтійське море та Каспійське море", "c) Чорне море та Балтійське море", "d) Азовське море та Каспійське море",
                "a) Чорне море та Азовське море", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        return questionsList;
    }

    private static List<QuestionsList> artQuestions () {

        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Хто з цих художників є представником українського авангарду?",
                "a) Іван Айвазовський", "b) Казимир Малевич", "c) Ілья Рєпін", "d) Микола Пимоненко",
                "b) Казимир Малевич", "");

        final QuestionsList question2 = new QuestionsList("Яка традиційна українська народна співоча форма є найпопулярнішою?",
                "a) Опера", "b) Симфонія", "d) Кобзарська пісня", "d) Рок-музика",
                "d) Кобзарська пісня", "");

        final QuestionsList question3 = new QuestionsList("Яке місто України славиться своїми мистецькими фестивалями та муралами?",
                "a) Львів", "b) Харків", "c) Київ", "d) Одеса",
                "a) Львів", "");

        final QuestionsList question4 = new QuestionsList("Який вид українського народного мистецтва відомий своєю вишивкою на тканинах, що має глибокі історичні та символічні значення?",
                "a) Гончарство", "b) Писанкарство", "c) Вишивка", "d) Розпис яєць",
                "c) Вишивка", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        return questionsList;
    }

    public static List<QuestionsList> getQuestions (String selectedTopicName) {
        switch (selectedTopicName) {
            case "history": return historyQuestions();
            case "literature": return literatureQuestions();
            case "geography": return geographyQuestions();
            default: return artQuestions();
        }
    }
}
