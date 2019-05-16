package com.pallas.jcl.creator.test.job.general;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.general.CommentTool;
import com.pallas.jcl.creator.job.general.GlobalSettings;

public class CommentToolUnitTest {
	
	private int offset = 15;
	private String comment = "TEST";
	private String longComment = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private String medComment = "Bonjour a tous. Ce commentaire ne sera pas si long que ca. Tout de meme, cela devrait etre coupe.";
	
	
	@Test
	public void create_comment_without_new_line() {
		assertTrue(CommentTool.generateComment(comment, false).equals(simulate(comment,false)));
	}
	
	@Test
	public void create_comment_with_new_line() {
		assertTrue(CommentTool.generateComment(comment, true).equals(simulate(comment,true)));
	}
	
	@Test
	public void create_long_comment_with_new_line() {
		assertTrue(CommentTool.generateComment(longComment, true).equals(simulate(longComment,true)));
	}
	
	@Test
	public void create_long_comment_without_new_line() {
		assertTrue(CommentTool.generateComment(longComment, false).equals(simulate(longComment,false)));
	}
	
	@Test
	public void create_medium_comment_with_new_line() {
		assertTrue(CommentTool.generateComment(medComment, true).equals(simulate(medComment,true)));
	}
	
	@Test
	public void create_medium_comment_without_new_line() {
		assertTrue(CommentTool.generateComment(medComment, false).equals(simulate(medComment,false)));
	}
	
	
	
	
	private String simulate(String comment,boolean line) {
		StringBuilder builder = new StringBuilder();
		int signCounter = offset;
			if(line) {
				builder.append("\n//*************************************\n//* ");
			}else {
				builder.append("\n//* ");
			}
			String[] tab = comment.split(" ");
			for(String x : tab) {

				if(!isInLine(signCounter,x)) {
					signCounter = offset;
					builder.append("\n//* ").append(x).append(" ");
					continue;
				}
				signCounter += x.length();
				builder.append(x).append(" ");
			}
			return builder.toString();
	}
	
	private static boolean isInLine(int currentLength, String toAppend) {
		return (currentLength + toAppend.length())<GlobalSettings.LINE_LENGTH;
	}
}
