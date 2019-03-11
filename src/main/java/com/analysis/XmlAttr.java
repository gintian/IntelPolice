package com.analysis;

public class XmlAttr {
   private String rule;
   private int[] objNums;
   private String[] prefixs;
   private int[] startNums;
   private String[] involvedcols;
   private int attrNums;
   private int[] prefixStartNums;
   private int[] suffixStartNums;

    public int[] getPrefixStartNums() {
        return prefixStartNums;
    }

    public void setPrefixStartNums(int[] prefixStartNums) {
        this.prefixStartNums = prefixStartNums;
    }

    public int[] getSuffixStartNums() {
        return suffixStartNums;
    }

    public void setSuffixStartNums(int[] suffixStartNums) {
        this.suffixStartNums = suffixStartNums;
    }

    public int getAttrNums() {
        return attrNums;
    }

    public void setAttrNums(int attrNums) {
        this.attrNums = attrNums;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int[] getObjNums() {
        return objNums;
    }

    public void setObjNums(int[] objNums) {
        this.objNums = objNums;
    }

    public String[] getPrefixs() {
        return prefixs;
    }

    public void setPrefixs(String[] prefixs) {
        this.prefixs = prefixs;
    }

    public int[] getStartNums() {
        return startNums;
    }

    public void setStartNums(int[] startNums) {
        this.startNums = startNums;
    }

    public String[] getInvolvedcols() {
        return involvedcols;
    }

    public void setInvolvedcols(String[] involvedcols) {
        this.involvedcols = involvedcols;
    }
}
