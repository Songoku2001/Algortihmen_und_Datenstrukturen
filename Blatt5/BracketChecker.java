package ads.Blatt5;

import java.util.ArrayList;
import java.lang.System;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.NoSuchElementException;


public class BracketChecker {

	public static interface Stack<T> {
		public void push(T e);
		public T pop() throws NoSuchElementException;
		public T top() throws NoSuchElementException;
		public boolean isEmpty();
		public int size();
	}

	public static class ArrayStack<T> implements Stack<T>{

		T[] a;
		int size=-1;
		public ArrayStack(int capacity) {
			a = (T[]) new Object[(capacity)];
		}

		@Override
		public void push(T e) {
			a[++size] = e;
		}

		@Override
		public T pop() throws NoSuchElementException {
			if (!isEmpty()) {
				return a[size--];
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public T top() throws NoSuchElementException {
			if (!isEmpty()) {
				return (T) a[size];
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public boolean isEmpty() {
			return size==-1;
		}

		@Override
		public int size() {
			return size;
		}
	}
	
	
	public static boolean check(String toCheck,
			                    int capacity) {

		ArrayStack<Character> a = new ArrayStack<Character>(capacity);

		for (int i=0; i<toCheck.length(); i++) {

			if (toCheck.charAt(i)=='(' || toCheck.charAt(i)=='{' || toCheck.charAt(i)=='[') {
				a.push(toCheck.charAt(i));
			} else {
				if (a.isEmpty()) {
					return false;
				}
				if (toCheck.charAt(i)==')' && a.top() == '('
								|| toCheck.charAt(i)=='}' && a.top() == '{'
								|| toCheck.charAt(i)==']' && a.top() == '[') {
					a.pop();
				}
			}
		}

		return a.isEmpty();
	}

	
	private static String[] readStringArray(String filename) {
		// open a file, read its lines, return them as an array.
		
		try {
		
			ArrayList<String> lines = new ArrayList<String>();
			
			// Kein Scanner, wÃ¤re viel zu langsam
			// Erzwingen von UTF-8 (sonst komische Ergebnisse unter Windows)
			Reader in = new InputStreamReader(new FileInputStream(filename),
					"UTF-8");

			BufferedReader reader = new BufferedReader(in);
			
			String s;
			while ((s = reader.readLine()) != null) {
				if (s.length() != 0 )
					lines.add(s);
			}
			
			reader.close();
			
			String[] result = new String[lines.size()];
			return lines.toArray(result);
		
		} catch (IOException e) {
		
			String msg = "I/O-Fehler bei " + filename + "\n" + e.getMessage();
			throw new RuntimeException(msg);
		
		}

	}

	
	public static void checkFile(String filepath) {
		String[] lines = readStringArray(filepath);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lines.length; ++i) {
			sb.append(lines[i]);
		}
		String content = sb.toString();
		System.out.format("File %s correct? %b", filepath, 
				          check(content, 1000));
	}
	

	public static void main(String[] args) {
		checkFile("Yourfile.java");
	}

}
