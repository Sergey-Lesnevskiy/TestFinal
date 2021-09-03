package methods;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selectors.LeaveSelector;
import utils.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LeaveMethod extends LeaveSelector {
    Properties props = new Properties();

    public void goToTheLeave() throws IOException {
        Log.info("Переходим на вкладку Leave ");
        props.load(new FileInputStream("src/main/resources/leave.properties"));
        leaveClick.click();
        assignLeaveClick1.click();
        Log.info("Заполнаяем Еmployee name");
        employeeNameLeave.sendKeys(props.getProperty("leave.employee"));
        Log.info("Выбираем тип отпуска");
        typeLeaveSelect.selectOptionContainingText("CAN - Vacation");
        //changTypeLeave.click();
        Log.info("Выбираем дату начала отпуска");
       // fromDateLeave.click();
        fromDateLeave.setValue(props.getProperty("leave.from"));
        clickFromDateLeave.click();
        Log.info("Выбираем дату окончания отпуска");
        toDateLeave.click();
       // toDateLeave.clear();
        toDateLeave.setValue(props.getProperty("leave.to"));
        clickToDateLeave.click();
        Log.info("Выбираем Duration");
        partialDaysLeave.selectOptionContainingText("Start Day Only");
       // startDayOnlyPartial.click();
        startDayHalfDay.selectOptionContainingText("Half Day");
      //  startDayHalfDayClick.click();
        startDayAfternoon.selectOptionContainingText("Afternoon");
      //  startDayAfternoonClick.click();
        Log.info("Запись комментария");
        сommentLeave.sendKeys(props.getProperty("leave.comments"));
        Log.info("Сохраняем данные");
        assignLeave1.click();
        okLeave.click();
    }

    public void findLeaveEmployee() {
        Log.info("Производим поиск сохранённого заявления на отпуск");
        checkLeaveListClick.click();
        allLeaveListClick.click();
        employeeNameLeaveList1.sendKeys(props.getProperty("leave.employee"));
        searchLeaveListClick.click();
    }

    public void checkLeaveEmployee() {
        Log.info("Проверяем наличие записи");
        ElementsCollection elements = tableLeaveList1.$$(withText("John Smith"));


    }

}
