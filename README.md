# BridgeDesignPattern

Overview:
The bridge design pattern is a type of structural design pattern which is used to split a large class into two separate inheritance hierarchies (a collection of 'is-a' relationships); one for the implementations and one for the abstractions. These hierarchies are then connected to each other via object composition, forming a bridge-like structure. This pattern is also known as the Handle-Body Design Pattern.

Scope of the Article:
1. This article provides an overview of the Bridge Design Pattern and its uses.
2. The article covers the problems that can be solved using the Bridge Design Pattern
3. It also covers the implementation of the Bridge Design Pattern in the Java programming language.
4. This article assumes that the reader has prior knowledge about object-oriented programming (OOP). Or can visit OOP.

When Will We Need Bridge Design Pattern?
Whenever we use Inheritance, our implementations (child classes) and the abstractions (parent classes) are generally coupled (dependent) on each other. This is because the implementations implement or extend the abstractions depending upon whether the abstraction is an abstract class or an interface. In these cases, we can use the Bridge Design Pattern to decouple this dependency.

Let's look at an example to understand this more clearly:

Consider a scenario where you wish to design a multimedia application that provides various views (or user interface) such as Long and Short views to display media content such as the artist's information and music albums.

Here, our abstraction (general idea of the objects) is the View and the specific kind of view like LongView or ShortView is our implementation (specific implementation of the object). Hence, this particular structure can be implemented using an abstract class (View class) that describes the basic view format along with four subclasses (Implementations), where each represents a unique view (user-interface) of a particular resource i.e., LongView of Artist, LongView of Album, ShortView of Artist, and ShortView of Album.

Here, we are using the Inheritance approach that works fine in some cases, but it has two major drawbacks:

1. It binds an implementation to the abstraction permanently. For example, if we want to add a new method to the abstract class View, then we will have to implement that same method in all the implementations. This is because the View class is the Parent class and implementation is a specific type of View i.e., it inherits the functionality of the View class. Hence, if a new method (functionality) is added in the View class, we must include that functionality in all the implementations.

2. The complexity of the application's structure increases exponentially when we try to add any more resources or views to our application i.e., the View class. For example, if we wish to add another resource, then we will have to implement two more subclasses (one for each view). Furthermore, if we wish to add a new View, we will have to implement three more subclasses (one for each resource). This is equivalent to implementing the classes obtained by the Cartesian Product of the abstraction classes set and the implementation classes set.

Hence, we need a way to avoid this permanent binding between an abstraction and its implementation.

How Does Bridge Design Pattern Work?

As discussed earlier, we use the Bridge Pattern whenever we need to avoid the inheritance-related binding between the abstraction and implementation. This decoupling helps us to separate the abstraction from the implementation allowing us to develop both the abstraction and the implementation independently of each other.

Let's look at the structure (UML diagram) of the Bridge Design Pattern and understand how it can be used to solve the above-discussed issue.

Structure of Bridge Design Pattern

The Bridge pattern splits a large class into two separate inheritance hierarchies one for the implementations and one for the abstractions. These hierarchies are then connected to each other via object composition, forming a bridge-like structure as shown below:

Here, we can notice that the bridge pattern uses the following terms:

Abstraction (Abstract Class)

1. It is the core of the bridge design patterns and defines the interface for the abstraction (such as the GUI i.e., the Graphical User Interface Layer of an App`).
2. This layer isn’t supposed to do any real work on its own i.e., it is the platform-independent layer.
3. It contains a reference to the implementor.
4. Abstraction defines the interface which is used by the client i.e., it is a platform-independent (or abstract) model which is used to provide the functionality to the client via the platform-specific implementations.

Implementor (Interface)

1. The implementor provides the actual function which is described in the abstraction. For example, if we are creating a Banking system application, the abstraction may define a function to withdraw some amount of money from a bank account. Here, the implementor will provide a list of operations (such as checking if the account has enough balance or not) that may be useful to carry out the cash withdrawal from the bank account.
2. It also defines the interface for implementation classes.

Concrete Abstractions (Normal Class)

1. It extends the abstract interface defined by Abstraction.
2. The concrete abstractions provide any specialized operation that may be required by the client. For example, the Abstraction may represent and define a basic user interface and its concrete abstraction may define a hand-held device's specialized user interface.

Concrete Implementations (Normal Class)

1. It implements the Implementor.
2. It provides the actual source code to implement the operations and functionality defined by the implementor interface.

Example:

Now, let's discuss how the Bridge design patterns can be used to solve the earlier discussed problem.

Since the GUI of an app can be considered as an abstraction and the resource or API as implementation in the bridge design pattern, we can consider the View class as Abstraction and the Resource class as the Implementation from the earlier discussed problem. Hence, after applying the bridge design pattern the structure of the application will be something like this:


Here, we can notice that the View class has two methods show() and buttons() which are overridden in the Concrete Abstraction (Here, LongView class). Also, the View class has a reference (or bridge) to the Resource class.

On the other side of the bridge, we have the Resource class which also contains two methods snippet() and url(), both of which are overridden in the Concrete Implementation (Here, Artist class).

Since there is only one link (object composition link) between the abstractions and the implementations in this bridge-like structure, we can create any number of concrete abstractions and any number of concrete implementations without affecting the class hierarchy on the unchanged side of the bridge. This independent extension and modification of both the abstraction and the implementations allow us to pair any number of concrete views with any number of concrete resources with the help of that object composition link.

This flexibility is not attainable in the Inheritance approach.

Implementation and Pseudocode:

Now, let's look at how can we practically implement the earlier described problem.

Step 1: Starter Code

Firstly, we have to write the starter code which in this case contains a View class that contains 4 subclasses, each denoting a particular view to display a particular resource in the application.

// Abstraction - Blueprint of actual GUI objects of the application
class View {
    show();
    buttons();
}

// Implementation - represents the Long View of the Artist resource in the application
class LongViewArtist extends View {
    override show();
    override button();
    snippet();
    url();
}

// Implementation - represents the Long View of the Album resource in the application
class LongViewAlbum extends View {
    override show();
    override button();
    snippet();
    url();
}

// Implementation - represents the Short View of the Artist resource in the application
class ShortViewArtist extends View {
    override show();
    override button();
    snippet();
    url();
}

// Implementation - represents the Long View of the Album resource in the application
class ShortViewAlbum extends View {
    override show();
    override button();
    snippet();
    url();
}

Step 2: Identify the Pattern

Let's try to add one more resource (say Playlist) to the application and observe how it will change our starter code:

// Abstraction - Blueprint of actual GUI objects of the application
class View {
    show();
    buttons();
}

// Implementation - represents the Long View of the Artist resource in the application
class LongViewArtist extends View {
    override show();
    override button();
    snippet();
    url();
}

// Implementation - represents the Long View of the Album resource in the application
class LongViewAlbum extends View {
    override show();
    override button();
    snippet();
    url();
}

// Implementation - represents the Short View of the Artist resource in the application
class ShortViewArtist extends View {
    override show();
    override button();
    snippet();
    url();
}

// Implementation - represents the Short View of the Album resource in the application
class ShortViewAlbum extends View {
    override show();
    override button();
    snippet();
    url();
 
// Implementation - represents the Long View of the Playlist resource in the application
class LongViewPlaylist extends View {
    override show();
    override button();
    snippet();
    url();

// Implementation - represents the Short View of the Playlist resource in the application
class ShortViewPlaylist extends View {
    override show();
    override button();
    snippet();
    url();
}

Here, we got to add two more classes upon the addition of one new resource. Hence, a total of 6 sub-classes are to be implemented in this approach.
Now, as we discussed earlier, this is the case where we can apply the Bridge design pattern as here we can identify the orthogonal dimensions in our View class i.e., the Abstraction (View) and the Implementation (Resource).

Step 3: Implement the Pattern

After identifying the abstraction and implementation in our code, we can construct the Bridge pattern in the following steps:

Create an abstract class for abstraction (Here, the Abstract class is the View class). Leave a link for the bridge in this class. (Initialize a variable that references the Implementation class)

Create concrete abstractions that extend this abstract class (Here, LongView and ShortView are the concrete abstractions of the View class)

Create the Implementation Interface (Since the resource object is platform-specific and is the implementation in our example, the Resource class can be referred to as the implementation interface)

Create the concrete implementations that extend this interface (Here, Artist, Album, and Playlist are the concrete implementation of the Resource interface)

Left Side of Bridge (Abstractions):

// Abstraction - Blueprint of actual GUI objects of the application
Abstract class View {
    IResource resource; //Bridge Link (object composition)
    show();
    buttons();
}

// Concrete Abstraction - The platform specific implementation of the Abstraction.
// Long View user interface for the application
class LongView extends View {
    override show();
    override button();
}

// Short View user interface for the application
class ShortView extends View {
    override show();
    override button();
}

Right Side of Bridge (Implementations):

// Implementation - Blueprint of actual resource objects of the application
Interface IResource {
    snippet();
    url();
}

// Concrete Implementation - The platform specific implementation of Resource objects.
// Actual platform-specific Artist resource that extends the Resource interface.
class Artist extends IResource {
    override snippet();
    override url();
}

// Actual platform-specific Album resource that extends the Resource interface.
class Album extends IResource {
    override snippet();
    override url();
}

// Actual platform-specific Playlist resource that extends the Resource interface.
class Playlist extends IResource {
    override snippet();
    override url();
}

Here, you can notice that we implemented only 5 sub-classes (two Views and three Resources) instead of the earlier 6.

Hence, because of this bridge formation between the two dimensions (View and Resource), we can have any number of concrete implementations and any number of concrete abstractions, each of which can be modified independently and can be paired with each other to achieve specific functionality.

Step 4: Testing the Pattern

To clearly understand the independence we achieved using the Bridge design pattern, let's obtain the application's Long View of Artist Resource object:

// Creating a new Artist Resource object.
my_artist = new Artist()
    
// Creating a Long type of graphical user interface for our Artist Resource object.
artist_view = new LongView(my_artist)

// Using the view to display the Artist Resource.    
artist_view.show()

Now, since every view extends the abstract class View that has a link to the interface Resource, we can pair any resource to any view by passing the concrete resource object to the particular View object at the time of its creation.

Note: Here, we can note that we have:

Views: {LongView, ShortView}

Resources: {Artist, Album, Playlist} Hence, we have a total of 5 different classes. Now, suppose we wish to create another type of view known as the Conceptual View. Now, we have:

Views: {LongView, ShortView, ConceptualView}

Resources: {Artist, Album, Playlist}

Now, if we implement the above given 6 classes using the Inheritance approach, we would have to create the following classes:

LongViewArtist
LongViewAlbum
LongViewPlaylist
ShortViewArtist
ShortViewAlbum
ShortViewPlaylist
ConceptualViewArtist
ConceptualViewAlbum
ConceptualViewPlaylist

On the other hand, if we use the Bridge Design Pattern, we will just have to create a new concrete abstraction to add the new ConceptualView:

Abstraction (View Abstract Class)

LongView
ShortView
Conceptual View

Implementor (Resources Interface)
Artist
Album
Playlist

Hence, while using the Bridge Design Patterns if we wish to add a new View in the application, we just need to create a new concrete abstraction instead of creating several sub-classes (one for each resource) like that in the Inheritance approach. This helps in the prevention of redundant code (reduces application complexity) and provides us the ability to modify concrete class (concrete abstraction and concrete implementations) independently.

Pros and Cons of Bridge Design Pattern:
Let's look at some advantages of the Bridge Design Patterns:

Decoupling - Decoupling is the process of avoiding or removing the binding between two inter-dependent classes. In Bridge Design Pattern, the decoupling process is executed via object composition and helps us to separate the platform-specific layer from the platform-dependent layer. This allows us to create platform-independent classes and apps.

Open/Closed Principle - It provides improved extensibility as we can extend the Abstraction and Implementor hierarchies independently.

Single Responsibility Principle - Since, the Abstractions and the Implementations are only connected via object compositions and both have independent inheritance hierarchies, modification done in the Abstraction does not affect the Implementation and vice versa.

Hiding implementation - Since, the client can only access the Abstraction Layer in the application, the Bridge Pattern helps us hide the platform-specific details from the clients.

Now, let's understand some of the disadvantages of the Bridge Design Patterns:

Complexity - The Bridge Design Pattern divides a big class that contains both the abstraction and the implementation into two separate class hierarchies. Hence, we need to manage two different classes along with their subclasses instead of one big class, thereby increasing the code complexity.

Multiple indirections - It could negatively affect the performance of the application because of the indirection of the request from the Abstraction to the Implementor.

Interfaces with single Implementation - When we have multiple interfaces with minimal or a single implementation, it becomes difficult to manage this pattern.

Difference between Bridge Pattern and Other Patterns:

1. Adapter Pattern - This design pattern is commonly used with an existing app to allow objects with incompatible interfaces to collaborate, whereas the Bridge Pattern is implemented up-front as a precautionary measure to allow us to develop various parts of an application independently of each other.

2. Strategy Pattern - The Strategy design pattern is also used in scenarios where we have a set of closely related classes and uses object composition similar to that of Bridge Pattern, but Strategy Pattern is a behavioral pattern and allows algorithms to be interchanged while using the Strategy Pattern.

3. Abstract Factory - It is a Creational Design Pattern that can be used along with the Bridge Design Patterns in cases where some of the abstractions defined by Bridge can only work with some specific implementations. In such cases, the Abstract Factory Pattern can encapsulate these relations and hide this information from the clients.

FAQs
Q1: When should we use the Bridge Design Pattern ? Bridge design patterns can be used to split the monolithic class (A big class that contains multiple components that are pointlessly coupled) into several class hierarchies i.e. when both the abstraction and the implementation can have different independent class hierarchies and we want to hide the implementation from the client.

Q2: What is the advantage of Bridge Pattern ? It enables the separation of platform-specific implementation from the platform-independent interface, thereby improving the extensibility of the application. It is also used to hide the implementation details from the client.

Q3: How the implementation is defined in the context of Bridge Pattern ? An implementation is a platform-dependent layer that is not bound permanently to an interface. Here, the interface refers to a class that describes the general idea of a real-world object and the implementation is the actual implementation of that object in a particular programming language.
