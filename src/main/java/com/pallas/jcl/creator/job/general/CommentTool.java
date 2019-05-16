package com.pallas.jcl.creator.job.general;

public class CommentTool {

	private final static int offset = 15;
	
	public static String generateComment(String comment,boolean line) {
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
