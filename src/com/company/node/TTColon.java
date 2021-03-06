/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class TTColon extends Token
{
    public TTColon(String text)
    {
        setText(text);
    }

    public TTColon(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTColon(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTColon(this);
    }
}
