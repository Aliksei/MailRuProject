package constants;

/**
 * Created by Aliksei_Tkachuk on 4/13/2015.
 */
public class MailConstants {

        private static final String url = "https://mail.ru/";
        private static final String homePageUrl="https://e.mail.ru/messages/inbox/?back=1";


        public static String getHomePageUrl() {
            return homePageUrl;
        }
        public static String getUrl() {
            return url;
        }
}


