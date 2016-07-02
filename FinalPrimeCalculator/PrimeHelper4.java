/*     */ package FinalPrimeCalculator;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class PrimeHelper4
/*     */ {
/*  12 */   static JOptionPane frame = new JOptionPane();
/*     */ 
/*  14 */   public static boolean isPrime(long num) { if (num == 2L) {
/*  15 */       return true;
/*     */     }
/*  17 */     if (num < 2L) return false;
/*  18 */     for (int i = 2; i <= (int)Math.sqrt(num) + 1; i++) {
/*  19 */       if (num % i == 0L) {
/*  20 */         return false;
/*     */       }
/*     */     }
/*  23 */     return true; }
/*     */ 
/*     */   public static long getNumber()
/*     */   {
/*  27 */     long number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number N: "));
/*  28 */     return number;
/*     */   }
/*     */ 
/*     */   public static long getN(long number) {
/*  32 */     boolean[] isPrime = new boolean[(int)number + 1];
/*  33 */     long N = 0L;
/*  34 */     for (int i = 2; i <= number; i++) {
/*  35 */       isPrime[i] = true;
/*     */     }
/*     */ 
/*  38 */     for (int i = 2; Math.pow(i, 2.0D) <= number; i++)
/*     */     {
/*  40 */       if (isPrime[i] != 0) {
/*  41 */         for (int j = i; i * j <= number; j++) {
/*  42 */           isPrime[(i * j)] = false;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  47 */     for (int i = 2; i <= number; i++) {
/*  48 */       if (isPrime[i] == 0) continue; N += 1L;
/*     */     }
/*  50 */     return N;
/*     */   }
/*     */ 
/*     */   public static void displayPrime(long number) {
/*  54 */     ArrayList nums = new ArrayList();
/*  55 */     long start = 2L; nums.add(Long.valueOf(start));
/*  56 */     int status = 1;
/*  57 */     long num = 3L;
/*  58 */     for (int count = 2; count < number; ) {
/*  59 */       for (int j = 2; j <= Math.sqrt(num); j++) {
/*  60 */         if (num % j == 0L) {
/*  61 */           status = 0;
/*  62 */           break;
/*     */         }
/*     */       }
/*  65 */       if (status != 0) {
/*  66 */         nums.add(Long.valueOf(num));
/*  67 */         count++;
/*     */       }
/*  69 */       status = 1;
/*  70 */       num += 1L;
/*     */     }
/*  72 */     JTextArea textArea = new JTextArea(Arrays.toString(nums.toArray()));
/*  73 */     JScrollPane scrollPane = new JScrollPane(textArea);
/*  74 */     textArea.setLineWrap(true);
/*  75 */     textArea.setWrapStyleWord(true);
/*  76 */     scrollPane.setPreferredSize(new Dimension(500, 500));
/*  77 */     JOptionPane.showMessageDialog(frame, scrollPane, "Anthony Bao's Prime Number Calculator", 0);
/*     */   }
/*     */   public static void theEnd() {
/*  80 */     for (int i = 0; i <= 100; i++) {
/*  81 */       char choice = JOptionPane.showInputDialog("====================Anthony Bao's Multi-Purpose Prime Number Calculator=====================\n                                                                         You name it, I do it\n Please enter the number corresponding to your choice:\n A: What are all prime numbers less than or equal to number?\n B: What are the first N prime numbers?\n C: How many prime numbers are less than or equal to number?\n D: Is this number prime?")
/*  87 */         .toLowerCase().charAt(0);
/*  88 */       if (choice == 'a') {
/*  89 */         long number = getNumber();
/*  90 */         long N = getN(number) + 1L;
/*  91 */         displayPrime(N);
/*     */       }
/*  93 */       else if (choice == 'b') {
/*  94 */         long number = getNumber() + 1L;
/*  95 */         displayPrime(number);
/*     */       }
/*  97 */       else if (choice == 'c') {
/*  98 */         long number = getNumber();
/*  99 */         long num = getN(number);
/* 100 */         JOptionPane.showMessageDialog(frame, Long.valueOf(num));
/*     */       }
/* 102 */       else if (choice == 'd') {
/* 103 */         long number = getNumber();
/* 104 */         boolean answer = isPrime(number);
/* 105 */         if ((number > 2147483647L) || (number < 0L)) { JOptionPane.showMessageDialog(frame, "An error occurred. The input may have been invalid");
/* 106 */         } else if (answer) { JOptionPane.showMessageDialog(frame, number + " is PRIME"); } else {
/* 107 */           if (answer) continue; JOptionPane.showMessageDialog(frame, number + " is NOT PRIME");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 112 */     theEnd();
/*     */   }
/*     */ }

/* Location:           /Users/timcoker/Desktop/PrimeNumberCalculator.jar
 * Qualified Name:     FinalPrimeCalculator.PrimeHelper4
 * JD-Core Version:    0.6.0
 */