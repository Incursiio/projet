package controle;

import java.util.Random;
import java.util.Scanner;

import modele.Arme;
import modele.ArmeEnum;
import modele.Armure;
import modele.ArmureEnum;
import jeu.*;

public class Menu {
	
	private Scanner input = new Scanner(System.in);
	private Random rand = new Random();
	private Jeu jeu;
	private ServiceJoueur serviceJoueur = ServiceJoueur.getInstance();
	private ServiceItem serviceItem= ServiceItem.getInstance();;
	
	public Menu()
	{
		this.jeu = new Jeu();// cr�e un jeu
		this.serviceItem = jeu.getServiceItem();//r�cup�re le service item cr�e par le jeu
		System.out.println(this.serviceJoueur);
		System.out.println(this.serviceItem);
		menu(); //menu de controle du jeu
	}
	public Menu(String s)
	{
		
	}
	
	public void menu()//menu qui permet de choisir ce qu'on veut faire
	{
		int choix=0;
		do
		{
			serviceJoueur.getJoueur().setPa(serviceJoueur.getJoueur().getPaRegen());//fais gagner des pa au joueur
			do
			{
				System.out.println("Que voulez-vous faire ?\n1- Deplacement\n2- Attaquer\n3- Voir Inventaire\n4- Voir Etat\n5- Fin du tour");
				do
				{
					choix = input.nextInt();
					if (choix<0 && choix>5)
					{
						System.out.println("Mauvaise saisie");
					}
				}while (choix<0 && choix>5);
				
				if (choix == 1)
				{
					menuDeplacement();//permet au joueur de se d�placer
				}
				
				else if(choix == 2)
				{
					menuAttaque();//permet au joueur d'attaquer
				}
				else if(choix==3)
				{
					menuInventaire();//permet au joueur de g�rer son �quipement
				}
				else if(choix==4)
				{
					serviceJoueur.getJoueur().afficheEtat();//permet au joueur de voir son statut
				}
			}while(serviceJoueur.getJoueur().getPa()>0 && choix!=5);//tant que les pa du joueur>0 et qu'il ne d�cide pas de finir son tour
			
			
		}while (serviceJoueur.getJoueur().getHp()>0);
		
	}
	
	public void menuDeplacement()//menu qui g�re les d�placements
	{
		
		int choix=-1;
			do
			{
				System.out.println("8 - Haut\n2 - Bas\n4 - Gauche\n6 - Droite\n5 - Stop\n");
				choix = input.nextInt();
				if (choix!=8 && choix!=2 && choix!=4 && choix!=6 && choix!=5)
					System.out.println("Mauvaise saisie");
				
			}while (choix!=8 && choix!=2 && choix!=4 && choix!=6 && choix!=5);
			
			switch (choix) {
			case 8:
				jeu.deplacerElement(0, serviceJoueur.getJoueur());//haut
				break;
			case 2:
				jeu.deplacerElement(1, serviceJoueur.getJoueur());//bas
				break;
			case 4:
				jeu.deplacerElement(2, serviceJoueur.getJoueur());//gauche
				break;
			case 6:
				jeu.deplacerElement(3, serviceJoueur.getJoueur());//droite
				break;
			case 0:
				
				break;
			default:
				break;
		}
			jeu.getGrille().afficher();	//affiche la grille
	}
	
	public void menuAttaque()
	{
		int choix=-1;
		
		do
		{
			System.out.println("8 - Haut\n2 - Bas\n4 - Gauche\n6 - Droite\n5 - Stop\n");
			choix = input.nextInt();
			if (choix!=8 && choix!=2 && choix!=4 && choix!=6 && choix!=5)
				System.out.println("Mauvaise saisie");
			
		}while (choix!=8 && choix!=2 && choix!=4 && choix!=6 && choix!=5);
			
		switch (choix) {
		case 8:
			if (jeu.rechercheCombatPossible(0)==jeu.getM1())//verifie si un monstre est pr�sent et s'il est �gal � m1
			{
				jeu.attaquerMonstre(0, jeu.getM1());//si true, il l'attaque
			}
			else if(jeu.rechercheCombatPossible(0)==jeu.getM2())//verifie si un monstre est pr�sent et s'il est �gal � m2
			{
				jeu.attaquerMonstre(0, jeu.getM2());//si true, il l'attaque
			}
				
			else
				System.out.println("Combat pas possible");
			break;
		case 2:
			if (jeu.rechercheCombatPossible(1)==jeu.getM1())//verifie si un monstre est pr�sent et s'il est �gal � m1
			{
				jeu.attaquerMonstre(0, jeu.getM1());//si true, il l'attaque
			}
			else if(jeu.rechercheCombatPossible(1)==jeu.getM2())//verifie si un monstre est pr�sent et s'il est �gal � m2
			{
				jeu.attaquerMonstre(0, jeu.getM2());//si true, il l'attaque
			}
			else
				System.out.println("Combat pas possible");
			break;
		case 4:
			if (jeu.rechercheCombatPossible(2)==jeu.getM1())//verifie si un monstre est pr�sent et s'il est �gal � m1
			{
				jeu.attaquerMonstre(0, jeu.getM1());//si true, il l'attaque
			}
			else if(jeu.rechercheCombatPossible(2)==jeu.getM2())//verifie si un monstre est pr�sent et s'il est �gal � m2
			{
				jeu.attaquerMonstre(0, jeu.getM2());//si true, il l'attaque
			}
			else
				System.out.println("Combat pas possible");
			break;
		case 6:
			if (jeu.rechercheCombatPossible(3)==jeu.getM1())//verifie si un monstre est pr�sent et s'il est �gal � m1
			{
				jeu.attaquerMonstre(3, jeu.getM1());//si true, il l'attaque
			}
			else if(jeu.rechercheCombatPossible(3)==jeu.getM2())//verifie si un monstre est pr�sent et s'il est �gal � m2
			{
				jeu.attaquerMonstre(3, jeu.getM2());//si true, il l'attaque
			}
			
			else
				System.out.println("Combat pas possible");
			break;
		case 0:
			
			break;
		default:
			break;
	}
		jeu.getGrille().afficher();
	}
	
	
	public void menuInventaire()
	{
		System.out.println(serviceJoueur.getJoueur().getInventaire());
		System.out.println("Que voulez-vous faire?");
		int choix=0;
		do//saisie control�
		{
			System.out.println("0 - Equiper\n1 - Desequiper\n2 - Drop\n3 - Quitter");
			choix = input.nextInt();
			if (choix<0 && choix>3)
				System.out.println("Mauvaise saisie");
			
		}while (choix<0 && choix>3);
		
		if (choix == 0)//equipe
		{
			int indiceItem=0;
			System.out.println("Choisissez l'objet � �quiper?");
			System.out.println(serviceJoueur.getJoueur().getInventaire());
			do//choisit un item
			{
				indiceItem = input.nextInt();
				if (indiceItem<0 && indiceItem>5)
					System.out.println("Mauvaise saisie");
				
			}while (indiceItem<0 && indiceItem>=5);
			
			if (serviceItem.getInventaire()[indiceItem-1] instanceof Arme)
			{
				Arme arme = (Arme) serviceItem.getInventaire()[indiceItem-1];
				serviceItem.equipeArme(arme, indiceItem);
			}
			else if (serviceItem.getInventaire()[indiceItem-1] instanceof Armure)
			{
				Armure armure = (Armure) serviceItem.getInventaire()[indiceItem-1];
				serviceItem.equipeArmure(armure, indiceItem);
			}
			else
			{
				System.out.println("Objet non �quipable");
			}
		}
		else if(choix==1)//desequipe
		{
			System.out.println("0 - Arme\n1 - Armure");
			do//choisit son arme ou son armure
			{
				choix = input.nextInt();
				if (choix<0 && choix>2)
					System.out.println("Mauvaise saisie");
				
			}while (choix<0 && choix>2);
			if (choix ==0 && serviceJoueur.getJoueur().getArme()!=null)
			{
				serviceItem.desequipeArme();
			}
			else if(choix==1 && serviceJoueur.getJoueur().getArmure()!=null)
			{
				serviceItem.desequipeArmure();
			}
			else
			{
				System.out.println("Vous n'avez rien � desequiper");
			}
		}
		else if (choix==2)//jete un item de son inventaire
		{
			int indiceItem = menuDropItem();
			serviceItem.dropItem(indiceItem);
		}
	}
	
	public int menuDropItem()
	{
		System.out.println("Que voulez-vous faire?");
		int choix=0;
		do
		{
			System.out.println("0 - Retirer un item de son inventaire\n1 - Ignorer");
			choix = input.nextInt();
			if (choix!=0 && choix!=1)
				System.out.println("Mauvaise saisie");
			
		}while (choix!=0 && choix!=1);
		if (choix == 0)
		{
			System.out.println("Choisissez l'item � abandonner");
			System.out.println(serviceJoueur.getJoueur().getInventaire());
			do
			{
				choix = input.nextInt();
				if (choix<0 && choix>5)
					System.out.println("Mauvaise saisie");
				
			}while (choix<0 && choix>=5);
		}
		else if (choix == 1)
		{
			choix = -1;
		}
		return choix;
	}
	
}
