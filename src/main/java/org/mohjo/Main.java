package org.mohjo;

import org.mohjo.iterator.BrowserHistory;
import org.mohjo.iterator.Iterator;
import org.mohjo.momento.Editor;
import org.mohjo.momento.History;
import org.mohjo.state.BrushTool;
import org.mohjo.state.Canvas;
import org.mohjo.state.SelectionTool;

public class Main {
    public static void main(String[] args) {
        /* For Momento design pattern

        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        System.out.println(editor.getContent());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent());

        */

        /* For State Design Pattern

        var canvas = new Canvas();
        canvas.setCurrentTools(new BrushTool());

        canvas.mouseDown();
        canvas.mouseUp();
        */

        /* For Iterator Design Pattern
           The problem part : The code below works totally fine, however if in the future we try to change the Data structure,
           which used to store the urls, that will affect the code outside our BrowserHistory class, for eg: if we use String[]
           instead of Arraylist then we can't use size() and add() So we have to design the structure
           in a way so that the only affecting class should be BrowserHistory class
           or a class which defines the rules not the class which uses those methods.


        var bh = new BrowserHistory();

        bh.push("a");
        bh.push("b");
        bh.push("c");
        bh.push("d");
        bh.pop();

        for(int i =0 ; i < bh.getUrls().size(); i++){
            System.out.println(bh.getUrls().get(i));
        }

        Solution code :
        */

        var bh = new BrowserHistory();

        bh.push("a");
        bh.push("b");
        bh.push("c");
        bh.push("d");
        bh.pop();

        var itr = bh.createIterator();
        while(itr.hasNext()){
            var currUrl = itr.current();
            System.out.println(currUrl);
            itr.next();
        }



    }
}