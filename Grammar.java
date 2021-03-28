package projet;



public class Grammar {
	public static String chat(String s) {

		String s1 = new String();

		if (s.contains("hi") || s.contains("hello")) {

			if (s.contains("bro")) {
				s1 = "Hello bro!";
				
			} else

			{
				s1 = "Hello there!";
				
			}
		} else if (s.contains("how are you")) {
			int decider = (int) (Math.random() * 3 + 1);
			if (decider == 1) {
				s1 = "Alhamdulillah. What about you?";
				
			} else if (decider == 2) {
				s1 = "Alhamdulillah. I am fine. What about you?";
				
			}
                        else if (decider == 3) {
				s1 = "I am doing fine. what about you ?";
				
			}
		} else if (s.contains("joke")) {
			s1 = "What�s the difference between Windows 95 and a virus? A virus does something.";
			
		} else if ((s.contains("thanks")) || (s.contains("thank you"))) {
			s1 = "it's my pleasure.";
                        
                        
                        } else if ((s.contains("who created ")) || (s.contains("created"))) {
			s1 = "People call him hama";
			
		} else if (s.contains("help")) {
			s1 = "In sha Allah I will try.";
			
		} else if (s.contains("ok")) {
			s1 = "Thank you sir.";
			
		} else if (s.contains("who are you")) {
			s1 = "I am your Personal Assistant.I am here to help you.";
			
		} else if (s.contains("can you")) {
			s1 = "I will try.";
			
		} else if ((s.contains("assalamualaikum")) || (s.contains("salam"))) {
			s1 = "Walaikumassalam.";
			
		} else if ((s.contains("morning")) || (s.contains("night")) || (s.contains("evening"))) {
			s1 = s;
			
		} else if ((s.contains("fine")) || (s.contains("i am ok")) || (s.contains("i am alright"))
				|| (s.contains("fantastic"))) {
			s1 = "Great!!";
			
		} else if ((s.contains("not fine")) || (s.contains("bad")) || (s.contains("sad"))) {
			s1 = "Don't worry everything will be ok.";
			
    		} else if (s.contains("what is your name")) {
			int decider = (int) (Math.random() * 3 + 1);
			if (decider == 1) {
				s1 = "my name is Nadia i am your personnel assistant.";
				
			} else if (decider == 2) {
				s1 = "Why?";
				
			}
                        else if (decider == 3) {
				s1 = "I'am Nadia nice to meet you";
				
			}
		} else if (s.contains("who am i?")) {

			s1 = "You are my Boss";
			
		} else if (s.contains("sing a song")) {

			s1 = "Tujhe dekha to ye jana sanam Pyar hota hain dewana sanam";
			
		} else if (s.contains("sing another song")) {

			s1 = "You just want attention, you don't want my heart\r\n"
					+ "Maybe you just hate the thought of me with someone new\r\n"
					+ "Yeah, you just want attention, I knew from the start\r\n"
					+ "You're just making sure I'm never gettin' over you";
			
		} else if (s.contains("esprit")) {

			s1 = "école supérieure privée d'ingénierie et de technologies";
			
		} else if (s.contains("why sorry")) {

			s1 = "because i couldn't give you your answer sir";
			
		} else if (s.contains("how old are you")) {

			s1 = "sorry it's personal";
			
		} else if (s.contains("married") || s.contains("boyfriend")) {

			s1 = "I am single";
			
		} else if (s.contains("i love you")) {

			s1 = "I love you too";
			
		} else if (s.contains("can you learn new")) {

			s1 = "I'm still learning";
			
		} else if (s.contains("speak in bangla")) {

			s1 = "kemon acho? valo acho?";
			
		} else if (s.contains("valo achi")) {

			s1 = "Amio valo achi";
			
		} else if (s.contains("play a song")) {

			s1 = "Please write on above youtube bar sir!";
			
		} else if (s.contains("stupid") || s.contains("nonsense")) {

			s1 = "Please don't use bad words!";
			
		} else if (s.contains("what you can't do")) {

			s1 = "i can do only a few things i'm still learning";
			
		} else if (s.contains("java")) {

			s1 = "programing language";
			
		} else if (s.contains("happy birthday")) {

			s1 = "sorry today is not my birthday";
			
		} else if (s.contains("send a email")) {

			s1 = "sir please you need to login on gmail and can send email.you can search email on google search bar";
			
		} else if (s.contains("cse")) {

			s1 = "computer science and engineering";
			
		} else if (s.contains("cse dept head of mist")) {

			s1 = "Air cmdt Afzal sir";
			
		} else if (s.contains("java course teacher")) {

			s1 = "lt cdr Arnab pal sir,Captain Naim sir,Lec Anik sir and Lec Antu sir";
			
		} else if (s.contains("sad")) {

			s1 = "please don't be sad!! everything will be alright";
			
		} else if (s.contains("wow")) {

			s1 = "thank you sir";
			
		} else if (s.contains("nice")) {

			s1 = "thank you sir";
			
		} else if (s.contains("very nice")) {

			s1 = "thank you sir";
			
		} else if (s.contains("wonderful")) {

			s1 = "thank you sir";
			
		} else if (s.contains("funny")) {

			s1 = "thank you sir";
			
		} else if (s.contains("not good") || s.contains("bad")) {

			s1 = "sorry sir";
			
		} else if (s.contains("dance")) {

			s1 = "sorry sir i can't";
			
		} else if (s.contains("artificial intelligence")) {

			s1 = "Artificial intelligence (AI) is an area of computer science that emphasizes the creation of intelligent machines that work and react like humans. Some of the activities computers with artificial intelligence are designed for include: Speech recognition.";
			
		} else if (s.contains("hi nadia") ||  s.contains("nadia") ) {

			s1 = "Yes Sir";
			
		}
		return s1;
	}
}
