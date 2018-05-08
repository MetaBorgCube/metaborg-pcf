package org.metaborg.lang.pcf.interpreter.natives;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import org.metaborg.lang.pcf.interpreter.generated.terms.*;
import org.metaborg.meta.lang.dynsem.interpreter.nabl2.NaBL2TermBuild;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;
import org.metaborg.meta.nabl2.interpreter.*;
import org.metaborg.meta.nabl2.stratego.*;
import org.metaborg.meta.nabl2.terms.*;
import org.metaborg.meta.nabl2.terms.generic.*;
import org.spoofax.interpreter.terms.IStrategoTerm;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@SuppressWarnings("unused") @NodeChild(value = "term", type = TermBuild.class) public abstract class nabl2_BindRec_paramsOfList_IBindTerm_1 extends NaBL2TermBuild 
{ 
  public nabl2_BindRec_paramsOfList_IBindTerm_1 (SourceSection source) 
  { 
    super(source);
  }

  @Specialization public IScopeTerm doGet(List_IBindTerm term)
  { 
    return IScopeTerm.create(getAstProperty(term.getStrategoTerm(), "Params"));
  }

  public static TermBuild create(SourceSection source, TermBuild term)
  { 
    return nabl2_BindRec_paramsOfList_IBindTerm_1NodeGen.create(source, term);
  }
}