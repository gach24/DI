package examples.unit01.exercise01;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class Match implements Serializable {
   // PRIVATE FIELDS
   private String local;
   private String visitor;
   private Division division;
   private int    localResult;
   private int    visitorResult;
   private Date   date;

   // CONSTRUCTORS
   public Match() {
      date = new Date();
   }

   public Match(String local, String visitor, Division division) {
      this();
      this.local     = local;
      this.visitor   = visitor;
      this.division  = division;
   }

   public Match(String l, String v, Division d, int lr, int vr, Date date) {
      this(l, v, d);
      this.localResult = lr;
      this.visitorResult = vr;
      this.date = date;
   }

   // PUBLIC METHODS
   public String  getLocal() { return local; }
   public void    setLocal(String local) { this.local = local; }
   public String  getVisitor() { return visitor; }
   public void    setVisitor(String visitor) { this.visitor = visitor; }
   public int     getLocalResult() { return localResult; }
   public void    setLocalResult(int localResult) { this.localResult = localResult; }
   public int     getVisitorResult() { return visitorResult; }
   public void    setVisitorResult(int visitorResult) { this.visitorResult = visitorResult; }
   public String  getDate() {
      return new SimpleDateFormat("dd-MM-yyyy").format(date);
   }
   public void    setDate(Date date) { this.date = date; }
   public Division getDivision() { return division;  }
   public void setDivision(Division division) { this.division = division; }

   public String getResult() {
      return getLocalResult() + " - " + getVisitorResult();
   }
   @Override
   public String toString() {
      return "-> " + local + ": " + localResult + " - " +
              visitor + ": " + visitorResult +
              " (" + getDivision() + ")" + "(" + getDate() + ")" ;
   }
}
