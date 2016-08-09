package org.metaborg.lang.pcf.interpreter;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.core.MetaborgException;
import org.metaborg.lang.pcf.interpreter.generated.PCFEntryPoint;
import org.metaborg.spoofax.core.Spoofax;

import com.google.inject.Module;

public class PCFRunner extends DynSemRunner {

	public PCFRunner(Spoofax S) throws MetaborgException {
		super(S, "PCF", new PCFEntryPoint());
	}
	
	public static void main(String... args) {
        if(args.length < 1) {
            System.err.println("Usage: "+PCFRunner.class.getName()+" FILES");
            return;
        }
        try(Spoofax S = new Spoofax(new DynSemRunnerModule(), new Module[0])) {
        	DynSemRunner runner = new PCFRunner(S);
        	for(String fileName : args) {
				FileObject file = S.resourceService.resolve(fileName);
				Object result = runner.run(file, System.in, System.out, System.err);
				System.out.println(result);
        	}
        } catch (MetaborgException e) {
            e.printStackTrace(System.err);
        }
    }

}