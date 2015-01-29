/*******************************************************************************
 * 2008-2015 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class TextFileHandler extends FileHandler {

	/** Uses the JAVA DEFAULT charset */
	public TextFileHandler(String filename) {
		super(filename);
	}

	/** Uses the JAVA DEFAULT charset */
	public TextFileHandler(File file) {
		super(file);
	}

	public TextFileHandler(String filename, String charset) {
		super(filename, charset);
	}

	public TextFileHandler(File file, String charset) {
		super(file, charset);
	}


	/*
	 * Class FileReader
	 *
	 * Convenience class for reading character files.
	 *
	 * The constructors of this class assume that the default character encoding and the
	 * default byte-buffer size are appropriate. To specify these values yourself,
	 * construct an InputStreamReader on a FileInputStream.
	 *
	 * FileReader is meant for reading streams of characters.
	 * For reading streams of raw bytes, consider using a FileInputStream.
	 *
	 */
	@Deprecated
	/** WARNING: Uses JAVA DEFAULT charset */
	public String readText() {

		StringBuffer buffer=new StringBuffer(STRING_BUFFER_LENGTH);

		try{
			BufferedReader br=
					new BufferedReader(
							new FileReader(file));

			try{
				String line;
				while((line=br.readLine()) != null){
					buffer.append(buffer.length()==0 ? line : "\n"+line);
				}

			}finally{
				close(br);
			}

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}catch(Exception e){
			e.printStackTrace();
		}

		return buffer.toString();

	}


	@Deprecated
	/** WARNING: Uses JAVA DEFAULT charset */
	public String readText(int lines) {

		StringBuffer buffer=new StringBuffer(STRING_BUFFER_LENGTH);

		try{
			BufferedReader br=
					new BufferedReader(
							new FileReader(file));

			try{
				String line;
				while((line=br.readLine()) != null && lines--!=0){
					buffer.append(buffer.length()==0 ? line : "\n"+line);
				}

			}finally{
				close(br);
			}

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}catch(Exception e){
			e.printStackTrace();
		}

		return buffer.toString();

	}



	/*
	 * Class FileWriter
	 *
	 * Convenience class for writing character files.
	 *
	 * The constructors of this class assume that the default character encoding and
	 * the default byte-buffer size are acceptable. To specify these values yourself,
	 * construct an OutputStreamWriter on a FileOutputStream.
	 *
	 * Whether or not a file is available or may be created depends upon the underlying
	 * platform. Some platforms, in particular, allow a file to be opened for writing
	 * by only one FileWriter (or other file-writing object) at a time.
	 * In such situations the constructors in this class will fail if the file involved
	 * is already open.
	 *
	 * FileWriter is meant for writing streams of characters. For writing streams of raw bytes,
	 * consider using a FileOutputStream.
	 *
	 */
	@Deprecated
	/** WARNING: Uses JAVA DEFAULT charset */
	public boolean writeText(String text) {

		try{
			BufferedWriter bw=
					new BufferedWriter(
							new FileWriter(file));

			try{
				bw.write(text);

			}finally{
				close(bw);
			}

			return true;

		}catch(IOException e){
			System.out.println(e);
		}catch(NullPointerException e){
		}catch(Exception e){
			e.printStackTrace();
		}

		return false;

	}



	/*
	 * Class InputStreamReader
	 *
	 * An InputStreamReader is a bridge from byte streams to character streams:
	 * It reads bytes and decodes them into characters using a specified charset.
	 * The charset that it uses may be specified by name or may be given explicitly,
	 * or the platform's default charset may be accepted.
	 *
	 * Each invocation of one of an InputStreamReader's read() methods may cause one
	 * or more bytes to be read from the underlying byte-input stream. To enable the
	 * efficient conversion of bytes to characters, more bytes may be read ahead from
	 * the underlying stream than are necessary to satisfy the current read operation.
	 *
	 * For top efficiency, consider wrapping an InputStreamReader within a BufferedReader.
	 * For example:
	 * BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	 *
	 */
	public String read() {

		StringBuffer buffer=new StringBuffer(STRING_BUFFER_LENGTH);

		try{
			BufferedReader br=
					new BufferedReader(
							new InputStreamReader(
									new FileInputStream(file), charset));

			try{
				String line;
				while((line=br.readLine()) != null){
					buffer.append(buffer.length()==0 ? line : "\n"+line);
				}

			}finally{
				close(br);
			}

		}catch(UnsupportedEncodingException e) {
			System.out.println(e);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}catch(Exception e){
			e.printStackTrace();
		}

		return buffer.toString();

	}


	public String read(int lines) {

		StringBuffer buffer=new StringBuffer(STRING_BUFFER_LENGTH);

		try{
			BufferedReader br=
					new BufferedReader(
							new InputStreamReader(
									new FileInputStream(file), charset));

			try{
				String line;
				while((line=br.readLine()) != null && lines--!=0){
					buffer.append(buffer.length()==0 ? line : "\n"+line);
				}

			}finally{
				close(br);
			}

		}catch(UnsupportedEncodingException e) {
			System.out.println(e);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}catch(Exception e){
			e.printStackTrace();
		}

		return buffer.toString();

	}



	/*
	 * Class OutputStreamWriter
	 *
	 * An OutputStreamWriter is a bridge from character streams to byte streams:
	 *
	 * Characters written to it are encoded into bytes using a specified charset.
	 * The charset that it uses may be specified by name or may be given explicitly,
	 * or the platform's default charset may be accepted.
	 *
	 * Each invocation of a write() method causes the encoding converter to be invoked
	 * on the given character(s). The resulting bytes are accumulated in a buffer
	 * before being written to the underlying output stream.
	 * The size of this buffer may be specified, but by default it is large enough
	 * for most purposes.
	 *
	 * Note that the characters passed to the write() methods are not buffered.
	 * For top efficiency, consider wrapping an OutputStreamWriter within a BufferedWriter
	 * so as to avoid frequent converter invocations.
	 * For example:
	 * Writer out=new BufferedWriter(new OutputStreamWriter(System.out));
	 *
	 */
	public boolean write(String text) {

		try{
			BufferedWriter bw=
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream(file), charset));

			try{
				bw.write(text);

			}finally{
				close(bw);
			}

			return true;

		}catch(UnsupportedEncodingException e) {
			System.out.println(e);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}catch(NullPointerException e){
		}catch(Exception e){
			e.printStackTrace();
		}

		return false;

	}


}