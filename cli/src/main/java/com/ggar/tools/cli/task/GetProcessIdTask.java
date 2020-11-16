package com.ggar.tools.cli.task;

import java.lang.reflect.Field;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

public class GetProcessIdTask extends Task<Long, Void> {
	
	private final Process process;
	
	public GetProcessIdTask(Process process) {
		this.process = process;
	}

	@Override
	public Long execute() {
		long result = -1;
		try {
			// for windows
			if (process.getClass().getName().equals("java.lang.Win32Process")
					|| process.getClass().getName().equals("java.lang.ProcessImpl")) {
				Field f = process.getClass().getDeclaredField("handle");
				f.setAccessible(true);
				long handl = f.getLong(process);
				Kernel32 kernel = Kernel32.INSTANCE;
				WinNT.HANDLE hand = new WinNT.HANDLE();
				hand.setPointer(Pointer.createConstant(handl));
				result = kernel.GetProcessId(hand);
				f.setAccessible(false);
			}
			// for unix based operating systems
			else if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
				Field f = process.getClass().getDeclaredField("pid");
				f.setAccessible(true);
				result = f.getLong(process);
				f.setAccessible(false);
			}
		} catch (Exception ex) {
			result = -1;
		}
		return result;
	}

}
