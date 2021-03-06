/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import java.util.*;
import com.company.analysis.*;

@SuppressWarnings("nls")
public final class ADclProtocol extends PProtocol
{
    private TTProtocoldcl _tProtocoldcl_;
    private TTLTurborg _tLTurborg_;
    private final LinkedList<PProtocolbody> _protocolbody_ = new LinkedList<PProtocolbody>();
    private TTRTurborg _tRTurborg_;

    public ADclProtocol()
    {
        // Constructor
    }

    public ADclProtocol(
        @SuppressWarnings("hiding") TTProtocoldcl _tProtocoldcl_,
        @SuppressWarnings("hiding") TTLTurborg _tLTurborg_,
        @SuppressWarnings("hiding") List<?> _protocolbody_,
        @SuppressWarnings("hiding") TTRTurborg _tRTurborg_)
    {
        // Constructor
        setTProtocoldcl(_tProtocoldcl_);

        setTLTurborg(_tLTurborg_);

        setProtocolbody(_protocolbody_);

        setTRTurborg(_tRTurborg_);

    }

    @Override
    public Object clone()
    {
        return new ADclProtocol(
            cloneNode(this._tProtocoldcl_),
            cloneNode(this._tLTurborg_),
            cloneList(this._protocolbody_),
            cloneNode(this._tRTurborg_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADclProtocol(this);
    }

    public TTProtocoldcl getTProtocoldcl()
    {
        return this._tProtocoldcl_;
    }

    public void setTProtocoldcl(TTProtocoldcl node)
    {
        if(this._tProtocoldcl_ != null)
        {
            this._tProtocoldcl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tProtocoldcl_ = node;
    }

    public TTLTurborg getTLTurborg()
    {
        return this._tLTurborg_;
    }

    public void setTLTurborg(TTLTurborg node)
    {
        if(this._tLTurborg_ != null)
        {
            this._tLTurborg_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tLTurborg_ = node;
    }

    public LinkedList<PProtocolbody> getProtocolbody()
    {
        return this._protocolbody_;
    }

    public void setProtocolbody(List<?> list)
    {
        for(PProtocolbody e : this._protocolbody_)
        {
            e.parent(null);
        }
        this._protocolbody_.clear();

        for(Object obj_e : list)
        {
            PProtocolbody e = (PProtocolbody) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._protocolbody_.add(e);
        }
    }

    public TTRTurborg getTRTurborg()
    {
        return this._tRTurborg_;
    }

    public void setTRTurborg(TTRTurborg node)
    {
        if(this._tRTurborg_ != null)
        {
            this._tRTurborg_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tRTurborg_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tProtocoldcl_)
            + toString(this._tLTurborg_)
            + toString(this._protocolbody_)
            + toString(this._tRTurborg_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tProtocoldcl_ == child)
        {
            this._tProtocoldcl_ = null;
            return;
        }

        if(this._tLTurborg_ == child)
        {
            this._tLTurborg_ = null;
            return;
        }

        if(this._protocolbody_.remove(child))
        {
            return;
        }

        if(this._tRTurborg_ == child)
        {
            this._tRTurborg_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tProtocoldcl_ == oldChild)
        {
            setTProtocoldcl((TTProtocoldcl) newChild);
            return;
        }

        if(this._tLTurborg_ == oldChild)
        {
            setTLTurborg((TTLTurborg) newChild);
            return;
        }

        for(ListIterator<PProtocolbody> i = this._protocolbody_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PProtocolbody) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._tRTurborg_ == oldChild)
        {
            setTRTurborg((TTRTurborg) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
