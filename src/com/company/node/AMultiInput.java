/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class AMultiInput extends PInput
{
    private PType _type_;
    private TTString _tString_;
    private TTComma _tComma_;
    private PInput _input_;

    public AMultiInput()
    {
        // Constructor
    }

    public AMultiInput(
        @SuppressWarnings("hiding") PType _type_,
        @SuppressWarnings("hiding") TTString _tString_,
        @SuppressWarnings("hiding") TTComma _tComma_,
        @SuppressWarnings("hiding") PInput _input_)
    {
        // Constructor
        setType(_type_);

        setTString(_tString_);

        setTComma(_tComma_);

        setInput(_input_);

    }

    @Override
    public Object clone()
    {
        return new AMultiInput(
            cloneNode(this._type_),
            cloneNode(this._tString_),
            cloneNode(this._tComma_),
            cloneNode(this._input_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultiInput(this);
    }

    public PType getType()
    {
        return this._type_;
    }

    public void setType(PType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
    }

    public TTString getTString()
    {
        return this._tString_;
    }

    public void setTString(TTString node)
    {
        if(this._tString_ != null)
        {
            this._tString_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tString_ = node;
    }

    public TTComma getTComma()
    {
        return this._tComma_;
    }

    public void setTComma(TTComma node)
    {
        if(this._tComma_ != null)
        {
            this._tComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tComma_ = node;
    }

    public PInput getInput()
    {
        return this._input_;
    }

    public void setInput(PInput node)
    {
        if(this._input_ != null)
        {
            this._input_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._input_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._type_)
            + toString(this._tString_)
            + toString(this._tComma_)
            + toString(this._input_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        if(this._tString_ == child)
        {
            this._tString_ = null;
            return;
        }

        if(this._tComma_ == child)
        {
            this._tComma_ = null;
            return;
        }

        if(this._input_ == child)
        {
            this._input_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._type_ == oldChild)
        {
            setType((PType) newChild);
            return;
        }

        if(this._tString_ == oldChild)
        {
            setTString((TTString) newChild);
            return;
        }

        if(this._tComma_ == oldChild)
        {
            setTComma((TTComma) newChild);
            return;
        }

        if(this._input_ == oldChild)
        {
            setInput((PInput) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
