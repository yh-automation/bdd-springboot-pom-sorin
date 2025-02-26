package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "landingpage")
public class LandingPage extends AbstractPage {
  @Value("${app.baseurl}")
  private String baseurl;

  private String title;

  public LandingPage toPage() {
    navigate(baseurl);
    assertThat(pageTitle(), is(equalTo(title)));
    return this;
  }

  public void toLogin() {
    clickBy(By.xpath("//a/span[contains(text(), 'Access the SuiteCRM 8 Demo')]"));
//    clickXpathJs("Access the SuiteCRM 8 Demo");
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }
}
