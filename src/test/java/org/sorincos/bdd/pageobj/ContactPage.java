package org.sorincos.bdd.pageobj;

import org.openqa.selenium.By;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "contactpage")
public class ContactPage extends AbstractPage {

  public ContactPage editContact(final String name) {
    //editText("last_name", name);
    editText(By.xpath("//*[@id='ngb-nav-0-panel']/div/scrm-field-layout/form/div[1]/div[1]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-group-field/div/div[3]/span[2]/scrm-dynamic-field/scrm-varchar-edit/input"), name);
    //clickId("SAVE");
    clickBy(By.xpath("//button[contains(text(), 'Save')]"));
    return this;
  }

  public boolean hasContact(final String name) {
    return isThere(name);
  }

  public ContactPage deleteCurrent() {
    //clickId("delete_button");
    clickBy(By.xpath("//a[contains(@class, 'dropdown-item') and normalize-space(.)='Delete']"));
    acceptAlert();
    return this;
  }
}
