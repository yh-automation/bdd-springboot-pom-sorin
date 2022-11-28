package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginpage")
public class LoginPage extends AbstractPage {

  public void doLogin(final String testUser, final String testPass) {
    editText(By.cssSelector("input[name='username']"), testUser);
    editText(By.cssSelector("input[name='password']"), testPass);
    clickId("login-button");
    assertThat(hasErrors(), is(false));
  }
}
