package org.jboss.forge.container.services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedCallable;
import javax.enterprise.inject.spi.AnnotatedParameter;

public class RemoteServiceAnnotatedParameter<R> implements AnnotatedParameter<R>
{
   private AnnotatedParameter<?> wrapped;

   public RemoteServiceAnnotatedParameter(AnnotatedParameter<?> wrapped)
   {
      this.wrapped = wrapped;
   }

   @Override
   public Type getBaseType()
   {
      return Object.class;
   }

   @Override
   public Set<Type> getTypeClosure()
   {
      return Collections.<Type> singleton(Object.class);
   }

   @Override
   public <T extends Annotation> T getAnnotation(Class<T> annotationType)
   {
      return wrapped.getAnnotation(annotationType);
   }

   @Override
   public Set<Annotation> getAnnotations()
   {
      return wrapped.getAnnotations();
   }

   @Override
   public boolean isAnnotationPresent(Class<? extends Annotation> annotationType)
   {
      return wrapped.isAnnotationPresent(annotationType);
   }

   @Override
   public int getPosition()
   {
      return wrapped.getPosition();
   }

   @Override
   @SuppressWarnings("unchecked")
   public AnnotatedCallable<R> getDeclaringCallable()
   {
      return (AnnotatedCallable<R>) wrapped.getDeclaringCallable();
   }

}
