package modules.expoModule.actions;

import java.util.Hashtable;

import modules.expoModule.entityDefinitions.KioskInvoice;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;

/**
 * Action de payer une facture et d'effectuer les changements concernés par
 * l'achat
 * @author Guillaume Lacasse
 */
public class PayInvoice extends AbstractAction
{
    /**
     * @throws Exception is ça fail
     */
    public PayInvoice() throws Exception
    {
	super(new KioskInvoice());
    }

    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception
    {
	KioskInvoice invoice = (KioskInvoice) entity;
	invoice = (KioskInvoice) invoice.get().get(0);
	invoice.setData("isPaid", true);
	invoice.save();

	return invoice.getUI(parameters);
    }
}
